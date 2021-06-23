<template>
  <el-tabs v-model="editableTabsValue"
           type="card"
           closable
           @tab-remove="removeTab"
           class="tabs">
    <el-tab-pane v-for="(item, index) in editableTabs"
                 :key="index"
                 :label="item.title"
                 :name="item.name"
                 style="padding:10px 20px 10px 20px;">
      {{item.content}}
    </el-tab-pane>
  </el-tabs>
</template>
<script>
export default {
  data () {
    return {
      editableTabsValue: '2',
      editableTabs: [{
        title: 'Tab 1',
        name: '1',
        content: 'Tab 1 content'
      }, {
        title: 'Tab 2',
        name: '2',
        content: 'Tab 2 content'
      }],
      tabIndex: 2
    }
  },
  methods: {
    addTab (targetName) {
      let newTabName = ++this.tabIndex + '';
      this.editableTabs.push({
        title: 'New Tab',
        name: newTabName,
        content: 'New Tab content'
      });
      this.editableTabsValue = newTabName;
    },
    removeTab (targetName) {
      let tabs = this.editableTabs;
      let activeName = this.editableTabsValue;
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            let nextTab = tabs[index + 1] || tabs[index - 1];
            if (nextTab) {
              activeName = nextTab.name;
            }
          }
        });
      }

      this.editableTabsValue = activeName;
      this.editableTabs = tabs.filter(tab => tab.name !== targetName);
    }
  }
}
</script>
<style scoped>
.tab {
  /* height: 100%; */
  border-radius: 30px;
}
</style>