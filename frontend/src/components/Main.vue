<template>
  <v-data-table
    :headers="headers"
    :items="users"
    :search="search"
    class="elevation-1"
    style="margin: 10px"
  >
    <template v-slot:top>
      <v-toolbar flat class="pt-3 mb-3">
        <v-text-field v-model="search" label="Buscar" class="mx-4"></v-text-field>

        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="800px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" class="mb-2" v-bind="attrs" v-on="on">New user</v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">{{formTitle}}</span>
            </v-card-title>
            <v-card-text>
              <v-container class="inputs-container-dialog">
                <v-row>
                  <v-col cols="6">
                    <v-text-field v-model="editedItem.name" label="Name" outlined></v-text-field>
                  </v-col>
                  <v-col cols="6">
                    <v-text-field v-model="editedItem.cpf" label="Cpf" outlined v-mask="'###.###.###-##'"></v-text-field>
                  </v-col>
                  <v-col cols="6">
                    <v-text-field v-model="editedItem.email" label="Email" outlined></v-text-field>
                  </v-col>
                  <v-col cols="6">
                    <v-autocomplete
                      :items="['Male', 'Female']"
                      v-model="editedItem.gender"
                      label="Gender"
                      outlined
                    ></v-autocomplete>
                  </v-col>
                  <v-col cols="5">
                    <v-text-field v-model="editedItem.dateOfBirth" label="Date of Birth" v-mask="'##/##/####'" outlined></v-text-field>
                  </v-col>
                  <v-col cols="5">
                    <v-text-field v-model="editedItem.nacionality" label="Nacionality" outlined></v-text-field>
                  </v-col>
                  <v-col cols="2">
                    <v-text-field v-model="editedItem.naturality" label="Naturality" outlined maxlength="2"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-btn color="orange darken-1" text @click="cleanFields">Clean</v-btn>
              <v-spacer></v-spacer>
              <v-btn color="red darken-1" text @click="closeDialog">Cancel</v-btn>
              <v-btn color="green darken-1" text @click="save">Save</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:[`item.actions`]="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="editItem(item)"
      >
        mdi-pencil
      </v-icon>
      <v-icon
        small
        @click="deleteItem(item)"
      >
        mdi-delete
      </v-icon>
    </template>
  </v-data-table>
</template>

<script>
import UserService from "../services/users";
import {mask} from 'vue-the-mask'

export default {
  directives: {mask},
  data() {
    return {
      users: [],
      dialog: false,
      search: '',
      editedIndex: -1,
      headers: [
        { text: "Name", value: "name" },
        { text: "CPF", value: "cpf" },
        { text: "Email", value: "email" },
        { text: "Gender", value: "gender" },
        { text: "Date of Birth", value: "dateOfBirth" },
        { text: "Nacionality", value: "nacionality" },
        { text: "Naturality", value: "naturality" },
        { text: 'Actions', value: 'actions', sortable: false },
      ],
      editedItem: {
        name: '',
        cpf: '',
        email: '',
        gender: '',
        dateOfBirth: '',
        nacionality: '',
        naturality: ''
      },
      defaultItem: {
        name: '',
        cpf: '',
        email: '',
        gender: '',
        dateOfBirth: '',
        nacionality: '',
        naturality: ''
      }
    }
  },

  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'Create new user' : 'Edit user'
    },
  },

  watch: {
    dialog (val) {
      val || this.closeDialog()
    },
  },

  created() {
    this.initialize();
  },

  methods: {

    initialize() {
      UserService.getAll()
        .then((response) => {
          console.log(response);
          this.users = response;
        })
        .catch((error) => {
          console.log(error);
        });
    },

    closeDialog() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },

    cleanFields() {
      /*this.name= '';
      this.cpf= '';
      this.email= '';
      this.gender= '';
      this.dateOfBirth= '';
      this.nacionality= '';
      this.naturality= '';*/
    },

    save() {

      if (this.editedIndex > -1) {
        UserService.update(this.editedItem.id, this.editedItem);
        Object.assign(this.users[this.editedIndex], this.editedItem);
      } else {
        UserService.register(this.editedItem)
          .then(() => {
            alert('User registered sucessfully.')
            this.closeDialog();
            this.cleanFields();
            this.initialize();
          })
          .catch(err => {
            alert(JSON.stringify(err.response.data));
          });
        this.users.push(this.editedItem)
      }
      this.closeDialog();
    },

    editItem (item) {
      this.editedIndex = this.users.indexOf(item);
      this.editedItem = Object.assign({}, item);
      console.log(this.editedItem);
      this.dialog = true;
    },

    deleteItem (item) {
      confirm('Are you sure you want to delete this item?') && UserService.delete(item.id);
      const index = this.users.indexOf(item);
      this.users.splice(index, 1);
    },
  },
}
</script>

<style scoped>
  .inputs-container-dialog .col  {
    height: 70px;
    padding: 3px;
  }
</style>