<template>
  <div>
    <el-tabs
      v-model="editableTabsValue"
      type="card"
      closable
      @tab-remove="removeTab"
    >
      <el-tab-pane
        v-for="(item, index) in editableTabs"
        :key="item.name"
        :label="item.title"
        :name="item.name"
      >
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
    data() {
      return {
        // editableTabsValue: this.$store.state.editableTabsValue,
        // editableTabs: this.$store.state.editableTabs
      }
    },
    computed: {
        editableTabsValue: {
            get() {
                return this.$store.state.editableTabsValue
            },
            set(value) {
                this.$store.state.editableTabsValue = value
            }
        },
        editableTabs: {
            get() {
                return this.$store.state.editableTabs
            },
            set(value) {
                this.$store.state.editableTabs = value
            }
        }
    },
    methods: {
      addTab(targetName) {
        let newTabName = ++this.tabIndex + '';
        this.editableTabs.push({
          title: 'New Tab',
          name: newTabName,
          content: 'New Tab content'
        });
        this.editableTabsValue = newTabName;
      },
      removeTab(targetName) {
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

<style>
</style>