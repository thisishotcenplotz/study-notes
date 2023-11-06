<template>
    <div class="demo">
        <h2>学生名称： {{name}}</h2>
        <h2>学生年龄： {{age}}</h2>
        <button @click="showName">点击显示</button>
    </div>
</template>

<script>
    export default {
      name:'Student'
      ,data(){
        return {
          name:'George',
          age: 18
        }
      },
      methods:{
        showName(){
          alert(this.name);
        }
      }
    }

</script>

<style>
    .demo{
      background-color: orange;
    }
</style>
