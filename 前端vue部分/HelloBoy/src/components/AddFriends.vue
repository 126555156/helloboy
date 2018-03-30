<template>
    <Modal v-model="isShow" title="添加好友">
        <Select v-model="addusername" filterable remote :remote-method="remoteMethod1" :loading="loading1" transfer>
            <Option v-for="(option, index) in options1" :value="option.value" :key="index">{{option.label}}</Option>
        </Select></br></br></br></br></br>
        <div slot="footer">
            <Button type="primary" shape="circle" icon="plus-round" long>添加好友</Button>
        </div>
    </Modal>
</template>
<script>
import { mapGetters, mapState } from "vuex";
export default {
  data() {
    return {
      addusername: "",
      options1: [],
      loading1: false,
      list: [
        "Alabama",
        "Alaska",
        "Arizona",
        "Arkansas",
        "California",
        "Colorado",
        "Connecticut",
        "Delaware",
        "Florida",
        "Georgia",
        "Hawaii",
        "Idaho",
        "Illinois",
        "Indiana",
        "Iowa",
        "Kansas",
        "Kentucky",
        "Louisiana",
        "Maine",
        "Maryland",
        "Massachusetts",
        "Michigan",
        "Minnesota",
        "Mississippi",
        "Missouri",
        "Montana",
        "Nebraska",
        "Nevada",
        "New hampshire",
        "New jersey",
        "New mexico",
        "New york",
        "North carolina",
        "North dakota",
        "Ohio",
        "Oklahoma",
        "Oregon",
        "Pennsylvania",
        "Rhode island",
        "South carolina",
        "South dakota",
        "Tennessee",
        "Texas",
        "Utah",
        "Vermont",
        "Virginia",
        "Washington",
        "West virginia",
        "Wisconsin",
        "Wyoming"
      ]
    };
  },
  computed: {
    ...mapGetters(["showAddFriends"]),
    isShow: {
      get: function() {
        return this.$store.state.showAddFriends;
      },
      // setter
      set: function(newValue) {
        this.$store.state.showAddFriends = newValue;
      }
    }
  },
  methods: {
    remoteMethod1(query) {
      if (query !== "") {
        this.loading1 = true;
        setTimeout(() => {
          this.loading1 = false;
          const list = this.list.map(item => {
            return {
              value: item,
              label: item
            };
          });
          this.options1 = list.filter(
            item => item.label.toLowerCase().indexOf(query.toLowerCase()) > -1
          );
        }, 200);
      } else {
        this.options1 = [];
      }
    }
  }
};
</script>
<style lang="scss">

</style>
