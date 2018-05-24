<template>
<modal name="Modal" transition="pop-out" :width="modalWidth" :height="400">
  <div class="box">
    <div class="box-part" id="bp-left">
      <div class="partition" id="partition-register">
        <div class="partition-title">CREATE ACCOUNT</div>
        <div class="partition-form">
          <form autocomplete="false">
            <input type="text" v-model="email" placeholder="Email">
            <input type="text" placeholder="Username">
            <input type="password" v-model="password" placeholder="Password">
          </form>

          <div style="margin-top: 42px">
          </div>

          <div class="button-set">
            <button v-on:click="signIn">Sign In</button>
            <button id="register-btn">Register</button>
          </div>

          <button class="large-btn google-btn" v-on:click="signInWithGoogle">connect with <span>google</span></button>
          <button class="large-btn facebook-btn" v-on:click="signInWithFacebook" >connect with <span>facebook</span></button>
        </div>
      </div>
    </div>
    <div class="box-part" id="bp-right">
      <div class="box-messages">
      </div>
    </div>
  </div>
</modal>
</template>


<template>
  <modal name="error-modal"
         :classes="['v--modal', 'error-modal', hasBugs && 'has-bugs']"
         :pivot-y="0.2"
         :width="400"
         :height="300"
         @before-open="beforeOpen"
         @before-close="beforeClose">
    <div class="error-modal-content">
      <sub :style="{opacity: hasBugs ? 1 : 0}">
        {{errorMessage}} 
      </sub>
    </div>
  </modal>
</template>


<script>


firebase.auth().getRedirectResult().then(
  (result) => {
    console.log('successful login ' + result.user )
      this.isLogged = firebase.auth().currentUser
      this.username = firebase.auth().currentUser && firebase.auth().currentUser.displayName
          // console.log(result.user);
}.bind(this),
error => {
  console.error(error)
  if (error.code === 'auth/account-exists-with-different-credential') {
    this.failedLogin = true
    this.$modal.show('LoginModal')
    // alert('failed login')
  }
})

      firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
      (user) => {
        console.log('successful login ' + this.failedLogin)
        this.failedLogin = false
        this.$modal.hide('LoginModal')
          // this.$emit('close');
      },
      error => {
        // handle errors
        this.errorMessage = error.message
        this.failedLogin = true
        // console.log('unsuccessful login ' + this.failedLogin)
      })
    


import firebase from 'firebase';

const MODAL_WIDTH = 656
export default {

  data () {
    return {
      errorMessage: '',
      hasBugs: false
    }
  },

  name: 'Modal',
  data () {
    return {
      modalWidth: MODAL_WIDTH,
      email: '',
      password: '',
      user: '',
    }
  },
  created () {
    this.modalWidth = window.innerWidth < MODAL_WIDTH
      ? MODAL_WIDTH / 2
      : MODAL_WIDTH
  },
    methods: {
      signUp: function() {
  Firebase.auth()
          .createUserWithEmailAndPassword(this.email, this.password)
          .then( user => { this.$router.replace('dashboard'); },
          error => { alert(error.message); });
}
    signIn() {
      firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
        (user) => {
          this.$router.replace('main');
        },
        (err) => {
          alert('Something is wrong!' + err.message);
        },
      );
    },

    signInWithGoogle() {
      const provider = new firebase.auth.GoogleAuthProvider();
      firebase.auth().signInWithRedirect(provider).then((result) => {
        this.user = result.user;
      }).catch(err => console.log(error));
    },

    signInWithFacebook() {
      const provider = new firebase.auth.FacebookAuthProvider();
      firebase.auth().signInWithRedirect(provider).then((result) => {
        this.user = result.user;
      }).catch(err => console.log(error));
    },

  },
}
</script>
<style scoped>
$background_color: #404142;
$google_color: #DBA226;
$facebook_color: #3880FF;
.box {
  background: white;
  overflow: hidden;
  width: 656px;
  height: 400px;
  border-radius: 2px;
  box-sizing: border-box;
  box-shadow: 0 0 40px black;
  color: #8b8c8d;
  font-size: 0;
  .box-part {
    display: inline-block;
    position: relative;
    vertical-align: top;
    box-sizing: border-box;
    height: 100%;
    width: 50%;
    &#bp-right {
      background: url("/static/images/eventar.png") no-repeat top left;
      border-left: 1px solid #eee;
    }
  }
  .box-messages {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
  }
  .box-error-message {
    position: relative;
    overflow: hidden;
    box-sizing: border-box;
    height: 0;
    line-height: 32px;
    padding: 0 12px;
    text-align: center;
    width: 100%;
    font-size: 11px;
    color: white;
    background: #F38181;
  }
  .partition {
    width: 100%;
    height: 100%;
    .partition-title {
      box-sizing: border-box;
      padding: 30px;
      width: 100%;
      text-align: center;
      letter-spacing: 1px;
      font-size: 20px;
      font-weight: 300;
    }
    .partition-form {
      padding: 0 20px;
      box-sizing: border-box;
    }
  }
  input[type=password],
  input[type=text] {
    display: block;
    box-sizing: border-box;
    margin-bottom: 4px;
    width: 100%;
    font-size: 12px;
    line-height: 2;
    border: 0;
    border-bottom: 1px solid #DDDEDF;
    padding: 4px 8px;
    font-family: inherit;
    transition: 0.5s all;
    outline: none;
  }
  button {
    background: white;
    border-radius: 4px;
    box-sizing: border-box;
    padding: 10px;
    letter-spacing: 1px;
    font-family: "Open Sans", sans-serif;
    font-weight: 400;
    min-width: 140px;
    margin-top: 8px;
    color: #8b8c8d;
    cursor: pointer;
    border: 1px solid #DDDEDF;
    text-transform: uppercase;
    transition: 0.1s all;
    font-size: 10px;
    outline: none;
    &:hover {
      border-color: mix(#DDDEDF, black, 90%);
      color: mix(#8b8c8d, black, 80%);
    }
  }
  .large-btn {
    width: 100%;
    background: white;
    span {
      font-weight: 600;
    }
    &:hover {
      color: white !important;
    }
  }
  .button-set {
    margin-bottom: 8px;
  }
  #register-btn,
  #signin-btn {
    margin-left: 8px;
  }
  .facebook-btn {
    border-color: $facebook_color;
    color: $facebook_color;
    &:hover {
      border-color: $facebook_color;
      background: $facebook_color;
    }
  }
  .google-btn {
    border-color: $google;
    color: $google;
    &:hover {
      border-color: $google;
      background: $google;
    }
  }
  .autocomplete-fix {
    position: absolute;
    visibility: hidden;
    overflow: hidden;
    opacity: 0;
    width: 0;
    height: 0;
    left: 0;
    top: 0;
  }
}
.pop-out-enter-active,
.pop-out-leave-active {
  transition: all 0.5s;
}
.pop-out-enter,
.pop-out-leave-active {
  opacity: 0;
  transform: translateY(24px);
}
</style>