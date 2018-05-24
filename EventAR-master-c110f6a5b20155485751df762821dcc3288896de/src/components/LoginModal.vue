<template>
<modal name="LoginModal" transition="pop-out" :width="modalWidth" :min-height="400" height="auto">
  <div class="box">
    <div class="box-part" id="bp-left">
    <div class="partition" id="partition-register">
    <div class="partition-title">CREATE ACCOUNT OR SIGN IN</div>
        <div class="partition-form">
          <form autocomplete="false">
            <input type="text" v-model="email" placeholder="Email"><br>
            <input type="text" placeholder="Username">
            <input type="password" v-model="password" placeholder="Password"><br>
          </form>

          <div style="margin-top: 42px" class="errormsg"> <p>{{errorMessage}}</p></div>
           
          <div class="button-set">
            <button id="goto-signin-btn" v-on:click="signIn">Sign In</button>
            <button id="register-btn" v-on:click="signUp">Register</button>
          </div>

          <button class="large-btn google-btn" v-on:click="signInWithGoogle">connect with <span>Google</span></button>
          <button class="large-btn facebook-btn" v-on:click="signInWithFacebook">connect with <span>facebook</span></button>
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

<script>
import firebase from 'firebase'

const MODAL_WIDTH = 656
export default {
  name: 'LoginModal',
  data () {
    return {
      modalWidth: MODAL_WIDTH,
      email: '',
      password: '',
      failedLogin: false,
      errorMessage: ' '
    }
  },
  methods: {
    signUp () {
      firebase.auth().createUserWithEmailAndPassword(this.email, this.password).then(
      (user) => {
        console.log('successful registration')
        this.failedLogin = false
      },
      error => {
        // handle errors
        this.errorMessage = error.message
        this.failedLogin = true
      })
    },

    signIn () {
      firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
      (user) => {
        console.log('successful login ' + this.failedLogin)
        this.failedLogin = false
        this.$modal.hide('LoginModal')
      },
      error => {
        // handle errors
        this.errorMessage = error.message
        this.failedLogin = true
        // console.log('unsuccessful login ' + this.failedLogin)
      })
    },

    signInWithGoogle () {
      const provider = new firebase.auth.GoogleAuthProvider()
      firebase.auth().signInWithRedirect(provider)
    },

    signInWithFacebook () {
      const provider = new firebase.auth.FacebookAuthProvider()
      firebase.auth().signInWithRedirect(provider)
    }

  }
}
</script>
<style scoped >
.box {
    background: white;
    overflow: hidden;
    width: 656px;
    height: 460px;
    border-radius: 2px;
    box-sizing: border-box;
    box-shadow: 0 0 40px black;
    color: #8b8c8d;
    font-size: 0;
}

.box .box-part {
    display: inline-block;
    position: relative;
    vertical-align: top;
    box-sizing: border-box;
    height: 100%;
    width: 50%;
}

.box #bp-right {
    background: url("/static/images/eventar.png") no-repeat;
    background-position: center; 
    background-size: 80%;
    border-left: 1px solid #eee;
}

.box .box-messages {
    position: absolute;
    left: 0;
    bottom: 0;
    width: 100%;
}

.box .box-error-message {
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

.box .partition {
    width: 100%;
    height: 100%;
}

.box .partition .partition-title {
    box-sizing: border-box;
    padding: 40px 15px 40px 15px;
    width: 100%;
    text-align: center;
    letter-spacing: 1px;
    font-size: 18px;
    font-weight: 300;
}

.box .partition .partition-form {
    padding: 0 20px;
    box-sizing: border-box;
}

.box input[type=password],
.box input[type=text] {
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

.errormsg {
    font-size: 12px;
    display: inline;
    padding: 5px;
    text-align: center;
}

.box button {
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
}

.box button:hover {
    border-color: #c7c8c9;
    color: #6f7071;
}

.box .large-btn {
    width: 100%;
    background: white;
}

.box .large-btn span {
    font-weight: 600;
}

.box .large-btn:hover {
    color: white !important;
}

.box .button-set {
    margin-bottom: 8px;
}

.box #register-btn,
.box #signin-btn {
    margin-left: 8px;
}

.box .facebook-btn {
    border-color: #3880FF;
    color: #3880FF;
}

.box .facebook-btn:hover {
    border-color: #3880FF;
    background: #3880FF;
}

.box .google-btn {
    border-color: #DBA226;
    color: #DBA226;
}

.box .google-btn:hover {
    border-color: #DBA226;
    background: #DBA226;
}

.box .autocomplete-fix {
    position: absolute;
    visibility: hidden;
    overflow: hidden;
    opacity: 0;
    width: 0;
    height: 0;
    left: 0;
    top: 0;
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
