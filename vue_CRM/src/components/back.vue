<template>

</template>

<script>
export default {
  created () {
    window.sessionStorage.clear()
    this.$message.success('注销登录成功');
    this.$router.replace({
      path: '/',

    })

  }

}
</script>

<style>
</style>