<template>
    <div class="demo">
        <h2>学校名称： {{name}}</h2>
        <h2>学校地址： {{addr}}</h2>
       <button @click="showName">点击显示</button>
    </div>
</template>

<script>
    export default {
      name:'School'
      ,data(){
        return {
          name:'MIT',
          addr:'Cambridge, MA'
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
