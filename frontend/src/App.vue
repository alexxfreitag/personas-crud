<template>
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      PERSONA CRUD
      <v-spacer></v-spacer>
      <v-dialog v-model="dialog" max-width="800px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn dark class="mb-2" v-bind="attrs" v-on="on">Source</v-btn>
        </template>
        <v-card>
          <v-card-title>
            <span>Link GitHub</span>
          </v-card-title>
          <v-card-text>
            <a :href="linkGithub" class="headline">{{linkGithub}}</a>
          </v-card-text>
           <v-card-actions>
             <v-spacer></v-spacer>
              <v-btn color="red darken-1" text @click="dialog = false">close</v-btn>
            </v-card-actions>
        </v-card>
      </v-dialog>
      
    </v-app-bar>

    <v-main>
      <Main/>
    </v-main>
  </v-app>
</template>

<script>
import Main from './components/Main';
import SourceService from "./services/source";

export default {
  name: 'App',

  components: {
    Main,
  },

  data: () => ({
    dialog: false,
    linkGithub: '',
    //
  }),

  created() {
    SourceService.get().then(response => this.linkGithub = response);
  }
};
</script>
