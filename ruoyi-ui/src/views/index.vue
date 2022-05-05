<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="12" :lg="12" style="padding-left: 10px">

        <div class="slide">
          <div class="slideshow">
            <ul>
              <li v-for="(img, index) in imgArray" v-show="index===mark" :key="index">
                <a href="javascript:;">
                  <img :src='img' class="rightullidiv">
                </a>
              </li>
            </ul>
          </div>
        </div>
        <hr />
      </el-col>
    </el-row>


    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <h2>学校辅导室预约系统</h2>
        <p>
          为同学和老师提供一个便捷的网上预约辅导室系统
        </p>
        <p>
          <b>当前版本:</b> <span>v{{ version }}</span>
        </p>
      </el-col>


    </el-row>
    <el-divider />
    <el-row :gutter="20">

      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>系统升级情况</span>
          </div>

          <el-collapse accordion>
            <el-collapse-item title="xxx升级 2022-05-01">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx升级 2022-01-01">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx升级 - 2021-07-12">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx升级 - 2021-06-25">
              <ol>
              </ol>
            </el-collapse-item>
            <el-collapse-item title="xxx升级 - 2021-05-25">
              <ol>
              </ol>
            </el-collapse-item>

          </el-collapse>
        </el-card>
      </el-col>


      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 支持中心网：
              www.abcdefg.cn
            </p>

            <p>
              <i class="el-icon-user-solid"></i> 支持中心QQ：
              123456789
            </p>
            <p>
              <i class="el-icon-user-solid"></i> 支持中心公众号：
              大学生学习支持中心
            </p>


          </div>
        </el-card>
      </el-col>





      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>支持中心负责人</span>
          </div>
          <div class="body">

            <p>
              <i class="el-icon-user-solid"></i> A老师：
              11111222222
            </p>
            <p>
              <i class="el-icon-user-solid"></i> B老师：
              15987463211
            </p>
          </div>
        </el-card>
      </el-col>



    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "1.0.0",
      mark: 0, //比对图片索引的变量
      imgArray: [
        require('../assets/images/fds1.jpg'),
        require('../assets/images/fds2.jpg'),
        require('../assets/images/fds3.jpg'),
        require('../assets/images/fds4.jpg'),
      ]
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    autoPlay () {
      this.mark++;
      if (this.mark === 4) { //当遍历到最后一张图片置零
        this.mark = 0
      }
    },
    play () {
      setInterval(this.autoPlay, 2500)
    },
    change (i) {
      this.mark = i
    },



  },
  created () {
    this.play()
  }
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }

  .rightullidiv{
    width:100%;
    height: 100%;
    background: #f2f2f2;
    display: flex;
    justify-content: center;
    align-items: center;
    .rightullidiv{
      max-width: 100%;
      max-height: 200px;
    }
  }
}
</style>


