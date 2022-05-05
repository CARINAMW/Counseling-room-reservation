<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日期" prop="orderDate">
        <el-date-picker clearable
          v-model="queryParams.orderDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="科目" prop="subjectName">
        <el-input
          v-model="queryParams.subjectName"
          placeholder="请输入科目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

<!--      <el-form-item label="学生账号" prop="studentId">-->
<!--        <el-input-->
<!--          v-model="queryParams.studentId"-->
<!--          placeholder="请输入学生账号"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->

      <el-form-item label="辅导室编号" prop="roomId">
        <el-select v-model="queryParams.roomId" placeholder="请选择辅导室编号" filterable clearable>
          <el-option
            v-for="dict in dict.type.a_croom_id"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="节数" prop="timeId">
        <el-select v-model="queryParams.timeId" placeholder="请选择节数" clearable>
          <el-option
            v-for="dict in dict.type.croom_time"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:stuorder:add']"
        >新增</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:stuorder:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:stuorder:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:stuorder:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="stuorderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="预约解疑辅导室编号" align="center" prop="studentOrderId" />-->
      <el-table-column label="日期" align="center" prop="orderDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="科目" align="center" prop="subjectName" />
      <el-table-column label="学生账号" align="center" prop="studentId" />
      <el-table-column label="辅导室编号" align="center" prop="roomId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.a_croom_id" :value="scope.row.roomId"/>
        </template>
      </el-table-column>
      <el-table-column label="节数" align="center" prop="timeId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.croom_time" :value="scope.row.timeId"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:stuorder:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:stuorder:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改解疑辅导室预约信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="日期" prop="orderDate">
          <el-date-picker clearable
            v-model="form.orderDate"
            type="date"
            value-format="yyyy-MM-dd"
            :picker-options="pickerOptions"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
<!--        <el-form-item label="科目" prop="subjectName">-->
<!--          <el-input v-model="form.subjectName" placeholder="请输入科目" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="教师账号" prop="uId">-->
<!--          <el-input v-model="form.uId" placeholder="请输入教师账号" />-->
<!--        </el-form-item>-->
        <el-form-item label="学生账号" prop="studentId">
          <el-input v-model="form.studentId" placeholder="请输入学生账号" />
        </el-form-item>
        <el-form-item label="辅导室编号" prop="roomId">
          <el-select v-model="form.roomId" placeholder="请选择辅导室编号" filterable clearable>
            <el-option
              v-for="dict in dict.type.a_croom_id"
              :key="dict.value"
              :label="dict.label"
:value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="节数" prop="timeId">
          <el-select v-model="form.timeId" placeholder="请选择节数">
            <el-option
              v-for="dict in dict.type.croom_time"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listStuorder, getStuorder, delStuorder, addStuorder, updateStuorder } from "@/api/system/stuorder";

export default {
  name: "Stuorder",
  dicts: ['a_croom_id', 'croom_time'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 解疑辅导室预约信息表格数据
      stuorderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderDate: null,
        subjectName: null,
        studentId: null,
        roomId: null,
        timeId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        orderDate: [
          { required: true, message: "日期不能为空", trigger: "blur" }
        ],
        subjectName: [
          { required: true, message: "科目不能为空", trigger: "blur" }
        ],
        uId: [
          { required: true, message: "教师账号不能为空", trigger: "blur" }
        ],
        studentId: [
          { required: true, message: "学生账号不能为空", trigger: "blur" }
        ],
        roomId: [
          { required: true, message: "辅导室编号不能为空", trigger: "change" }
        ],
        timeId: [
          { required: true, message: "节数不能为空", trigger: "change" }
        ]
      },
      pickerOptions: {
        disabledDate(time) {
          const times = new Date(new Date().toLocaleDateString()).getTime() + 4 * 8.64e7 - 1
          return time.getTime() < Date.now() || time.getTime() > times// 如果没有后面的-8.64e7就是不可以选择今天的
        }
      },
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询解疑辅导室预约信息列表 */
    getList() {
      this.loading = true;
      if(this.$store.state.user.name!="admin"){
        this.queryParams.studentId=this.$store.state.user.name;
      }

      // this.stuorderList.studentId="2020123456";
      listStuorder(this.queryParams).then(response => {
        this.stuorderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        studentOrderId: null,
        orderDate: null,
        subjectName: null,
        uId: null,
        studentId: null,
        roomId: null,
        timeId: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.studentOrderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加解疑辅导室预约信息";
      this.form.studentId=this.$store.state.user.name;
      this.form.uId="123456";
      this.form.subjectName="计算机";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const studentOrderId = row.studentOrderId || this.ids
      getStuorder(studentOrderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改解疑辅导室预约信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.studentOrderId != null&&this.title == "修改解疑辅导室预约信息") {
            updateStuorder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.studentOrderId=String(this.form.timeId)+String(this.form.orderDate)+this.form.studentId;
            addStuorder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const studentOrderIds = row.studentOrderId || this.ids;
      this.$modal.confirm('是否确认删除解疑辅导室预约信息编号为"' + studentOrderIds + '"的数据项？').then(function() {
        return delStuorder(studentOrderIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/stuorder/export', {
        ...this.queryParams
      }, `stuorder_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
