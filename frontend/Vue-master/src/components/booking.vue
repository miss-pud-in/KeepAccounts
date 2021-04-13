<template>
  <div id="mainapp">

    <el-card class="box-card">
      <div slot="header" class="clearfix" >
        <span>卡片名称</span>
      </div>
    </el-card>

    <el-card class="box-card2" >
      
      <div id="bookapp"><vue-scroll :ops="ops" style="width:100%;height:100%">
      <el-form ref="form" :model="form" label-width="60px" style="text-align:left">
        <el-row>
          <el-col :span="12">
            <el-form-item label="金额">
              <el-input v-model="form.money" size="small" suffix-icon="el-icon-edit" style="width:120px" placeholder="请输入数字"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="类型">
              <el-radio-group v-model="form.typeRadio" size="small">
                <el-radio-button label="支出"></el-radio-button>
                <el-radio-button label="收入"></el-radio-button>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <el-form-item label="日期">
          <div class="block">
            <el-date-picker v-model="form.bookData" align="right" type="date" placeholder="选择日期" 
            :picker-options="pickerOptions" value-format="yyyy-MM-dd">
            </el-date-picker>
          </div>
        </el-form-item>

        <el-form-item label="标签">
          <el-radio-group v-model="form.bookLabel">
            <el-radio  :key="radio"  v-for="radio in form.bookLabels" 
              :label="radio" size="mini" border style="margin:5px 5px 5px 0" >
              {{radio}}
            </el-radio>
          
            <el-select v-if="selectLabelVisible" v-model="selectLabelValue" placeholder="请选择账本" ref="saveTagselectLabel" 
              size="small" @keyup.enter.native="handleselectLabelConfirm" @change="handleselectLabelConfirm" >
              <el-option v-for="item in form.booksLabels" :key="item" :value="item"></el-option>
            </el-select>
            <el-button v-else class="button-new-tag" size="small" @click="showSelectLabel" style="margin:5px 5px 5px 0">选择其它标签
            </el-button>

            <el-input class="input-new-tag" v-if="inputVisible" v-model="inputValue" ref="saveTagInput" 
              size="mini" @keyup.enter.native="handleInputConfirm" @blur="handleInputConfirm" 
              style="margin:5px 5px 5px 0;width: 100px;">
            </el-input>
            <el-button v-else class="button-new-tag" size="mini" @click="showInput" style="margin:5px 5px 5px 0">+ 添加新标签
            </el-button>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="账本" >
          <el-radio-group disabled size="small">
            <el-radio-button>{{form.bookData.substring(0,4)}}{{form.bookData.substring(5,7)}}月账单</el-radio-button>
          </el-radio-group>
          <el-tag :key="tag" v-for="tag in form.bookTags" closable :disable-transitions="false" @close="handleClose(tag)"
            style="margin-right: 5px" effect="plain">
            {{tag}}
          </el-tag>
          <el-select v-if="selectVisible" v-model="selectValue" placeholder="请选择账本" ref="saveTagSelect" 
            size="small" @keyup.enter.native="handleSelectConfirm" @change="handleSelectConfirm" >
            <el-option v-for="item in form.booksTags" :key="item" :value="item"></el-option>
          </el-select>
          <el-button v-else class="button-new-tag" size="small" @click="showSelect" style="margin:5px 5px 5px 0">+ 添加至其他账本
          </el-button>
        </el-form-item>

        <el-form-item label="备注">
          <el-input v-model="form.remark" suffix-icon="el-icon-edit" style="width:250px" placeholder="请输入内容"></el-input>
        </el-form-item>

      </el-form></vue-scroll>
      </div>
    
      </el-card>
      
  </div>
</template>

<script>
import Navigation from './Navigation.vue'
export default {
  components: { Navigation },
  data() {
      return {
        form: {
          money: '',//金额
          book:'202003月账本',//月账本
          bookTags: ['账本1', '账本2', '账本123'],//已添加的自定义账本集
          booksTags: ['账本3', '账本4', '账本523'],//全部自定义账本集
          bookLabels: ['标签1', '标签2', '标签123','饮食','美容'],//显示的标签集
          booksLabels:['早餐','午餐','晚餐'],//未显示的标签集
          bookData:'', //日期
          bookLabel:'饮食', //选定标签
          typeRadio: '支出',  //支出/收入
          remark:'', //备注
          
        },
        inputVisible: false,
        selectVisible: false,
        inputValue: '',
        selectValue: '',
        selectLabelVisible:false,
        selectLabelValue:'',

        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },

        ops: {  //滚动条样式
          bar: {
            onlyShowBarOnScroll: false, //是否只有滚动的时候才显示滚动条
            background: "pink",//滚动条颜色
            opacity: 0.5,//滚动条透明度
            "overflow-x": "hidden"
          }
        }

      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },

      handleClose(tag) {
        this.form.bookTags.splice(this.form.bookTags.indexOf(tag), 1);
        this.form.booksTags.push(tag);
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      showSelect() {
        this.selectVisible = true;
      },

      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
          let i=this.form.booksLabels.indexOf(inputValue);
          let j=this.form.bookLabels.indexOf(inputValue);
          if(i<0&&j<0){
            this.form.bookLabels.push(inputValue);
            this.form.bookLabel=inputValue;
          }
          else{
            this.$message({
              message: '请勿重复添加标签！',
              type: 'warning'
            });
          }
        }
        this.inputVisible = false;
        this.inputValue = '';
      },

      handleSelectConfirm() {
        let selectValue = this.selectValue;
        if (selectValue) {
          this.form.bookTags.push(selectValue);
          this.form.booksTags.splice(this.form.booksTags.indexOf(selectValue),1);
        }
        this.selectVisible = false;
        this.selectValue ='';
      },

      
      showSelectLabel() {
        this.selectLabelVisible = true;
      },

      handleselectLabelConfirm() {
        let selectLabelValue = this.selectLabelValue;
        if (selectLabelValue) {
          this.form.bookLabels.push(selectLabelValue);
          this.form.booksLabels.splice(this.form.booksLabels.indexOf(selectLabelValue),1);
        }
        this.form.bookLabel=selectLabelValue;
        this.selectLabelVisible= false;
        this.selectLabelValue ='';
      },
    }
}
</script>

<style scoped>
 .text {
    font-size: 14px;
  }

  .item {
    margin: 0px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    margin: 18px 10px 18px 20px;
    width: 460px;
    height: 560px;
    opacity: 0.9;
    overflow:auto;
    float: left;
  }

  .box-card2 {
    margin: 18px 10px 18px 20px;
    width: 460px;
    height: 560px;
    opacity: 0.9;
    overflow:auto;
    float: left;
    position:absolute;
    left:480px;
    top:0px;

  }
  
  #bookapp{
    width: 400px;
    height: 450px;
    border:0px solid rgb(243, 231, 231);
    border-radius:5px;
    background:#faf0ee;
    border: 5px solid rgba(243, 235, 235, 0.5);
    background-clip: padding-box;
    margin:0px;
    padding: 10px;
    position: relative;
    top:-5px;
    left: -5px;

  }

</style>