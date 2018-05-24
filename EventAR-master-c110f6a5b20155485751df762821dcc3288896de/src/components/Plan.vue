<template>
<div class="plan" style="padding-top:100px">

  <!-- Section 1 -->
  <section style="background-color:#fff">
    <div class="container ">

      <div class="row ">
        <div class="col-xs-12 col-sm-6" data-aos="fade-right">
          <div class="hvr-underline-from-left">
            <h1 class="section-heading">Plan</h1>
          </div>
        </div>

        <!-- Button trigger modal -->
        <div class="col-xs-12 col-sm-6">
          <div class="flex-search dont-display1">
            <span class="input-group-btn">
            <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                <span class="search-button-text">SEARCH <i class="fa fa-search"></i></span>
            </button>
            </span>
          </div>
        </div>
      </div>

      <!-- Modal -->
      <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Plan</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
            </div>

            <div class="modal-body">
              <!-- Event type -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Event Type</label></h5>
                <input class="form-control" type="text" placeholder="What type of event would you like to plan?">
                <select multiple class="form-control" id="exampleFormControlSelect2">
                  <option>Wedding</option>
                  <option>Birthday</option>
                  <option>Ceremony</option>
                  <option>Party</option>
                  <option>Family Event</option>
                  <option>Graduation</option>
                  <option>Conference/Meeting</option>
                  <option>Seminars</option>
                  <option>Exhibition</option>
                  <option>Evening Reception</option>
                  <option>Networking Event</option>
                  <option>Product Launch/PR Event</option>
                </select>
              </div>

              <!-- location -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Venue Location</label></h5>
                <input class="form-control" type="text" placeholder="Where would you like to host this event?">
                <select multiple class="form-control" id="exampleFormControlSelect2">
                  <option>Near me</option>
                  <option>Central London</option>
                  <option>North London</option>
                  <option>East London</option>
                  <option>South London</option>
                  <option>West London</option>
                  <option>Greater London</option>
                </select>
              </div>
              <hr />

              <!-- Date -->
              <div class="control-group">
                <h5><label for="exampleFormControlSelect2">Date</label></h5>
                <div class="controls input-append date form_date" data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                  <input class="form-control" size="16" type="text" value="When do you plan to hold this event?" readonly>
                  <span class="add-on"><i class="icon-remove"></i></span>
                  <span class="add-on"><i class="icon-th"></i></span>
                </div>
                <input class="form-control" type="hidden" id="dtp_input2" value="" />
                <!-- <br/> -->
              </div>
              <hr />

              <!-- Capacity -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Capacity</label></h5>
                <input class="form-control" type="text" placeholder="How many guests will be attending?">
                <select multiple class="form-control" id="exampleFormControlSelect2">
                  <option>0 — 20</option>
                  <option>20 — 50</option>
                  <option>50 — 100</option>
                  <option>100 — 200</option>
                  <option>200 — 300</option>
                  <option>300 — 400</option>
                  <option>400 — 600</option>
                  <option>600 — 800</option>
                  <option>800 — 1,000</option>
                  <option>1,000+</option>
                </select>
              </div>

              <!-- Vendors -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Vendors</label></h5>
                <input class="form-control" type="text" placeholder="Which vendor(s) would you require for your event?">
                <div class="instruction">
                  (Check the boxes)
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                Photographer
              </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Videographer
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Dancers
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Musicians
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Caterers
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Florist
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Comedian
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Calligrapher
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Lighting
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Photobooth
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Car Rentals
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Variety Acts
                </label>
                </div>
              </div>
              <hr />

              <!-- Budget -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Budget</label></h5>
                <div data-role="main" class="ui-content">
                  <form method="post">
                    <div data-role="rangeslider">
                      <label for="price-min">£0</label>
                      <input type="range" name="price-min" id="price-min" value="200" min="0" max="1000">
                      <label for="price-max">£100,000</label>
                    </div>
                  </form>
                </div>
              </div>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Search</button>
            </div>
          </div>
        </div>
      </div>
      <!-- End of Modal -->
      <br />

      <div class="row ">
        <div class="col-md-6 mx-auto ">
          <h2 class="subheading">Event Packages</h2>
        </div>
        <div class="col-md-6">
          <div class="flex-search dont-display2">
            <span class="input-group-btn">
            <button type="button" class="btn btn-default btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                <span class="search-button-text">SEARCH <i class="fa fa-search"></i></span>
            </button>
            </span>
          </div>
        </div>
        <div class="scrollmenu"><br />
          <figure class="figure">
            <img src="/static/assets/images/plan/wedding.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Weddings</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/birthday.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Birthdays</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/ceremony.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Ceremonies</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/party.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Parties</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/family.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Family Events</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/meeting.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Conference/Meetings</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/exhibition.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Exhibitions</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/pr.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Product Launch/PR Event</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/networking.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Networking Event</figcaption>
          </figure>
        </div>
      </div>

      <br /><br />

      <div class="row ">
        <div class="col-lg-12">
          <h2 class="subheading">Exclusive Venues</h2>
        </div>
        <div class="scrollmenu"><br />
          <figure class="figure">
            <img src="/static/assets/images/plan/venue1.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Wedding Venues</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/banquet.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Banqueting Halls</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/venue2.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Conference Rooms</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/venue3.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Performance Spaces</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/venue4.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Sports Event</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/venue1.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Party Venues</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/venue2.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Exhibition Venues</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/venue3.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Large Venues</figcaption>
          </figure>
        </div>
      </div>

      <br /><br />

      <div class="row ">
        <div class="col-lg-12 mx-auto ">
          <h2 class="subheading">Popular Vendors</h2>
        </div>
        <div class="scrollmenu"><br />
          <figure class="figure">
            <img src="/static/assets/images/plan/caterer.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Caterers</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/florist.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Florists</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/photographer.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Photographer</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/videographer.png" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Videographer</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/dancer.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Dancers</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/musician.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Musicians/DJ</figcaption>
          </figure>
          <figure class="figure">
            <img src="/static/assets/images/plan/acts.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">Variety Acts</figcaption>
          </figure>
        </div>
      </div>
    </div>
  </section>



</div>
</template>

<script>
export default {
  name: 'Plan',
  data () {
    return {}
  },
  components: {}
}
</script>

<style scoped>
/* PLAN PAGE CSS */

/* NAVIGATION */

body {
  margin-top: 100px;
}

/* SCROLL MENU  */

div.scrollmenu {
  background-color: #f8f9fa;
  overflow: auto;
  white-space: nowrap;
  height: 300px;
}

div.scrollmenu a {
  display: inline-block;
  color: #333;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}

div.scrollmenu a:hover {
  background-color: #777;
}

.figure-caption {
  font-family: 'Poppins', sans-serif;
  font-size: 15px;
  font-weight: 500;
  color: #2c3e50;
}

.figure {
  padding-left: 10px;
}

figure > img {
  height: 214px;
}

.figure-img:hover {
  padding:2px;
   border:2px solid #bbb;
}

/* SUBHEADING */

.subheading {
  font-family: 'Poppins', sans-serif;
  font-size: 30px;
  color: #900c3f;
  padding-bottom: 20px;
  border-style: none;
}

h2.subheading:hover,
h2,
h2:hover {
  border-style: none;
}

/* SEARCH MODAL */

input {
  color: #6c757d;
}

.instruction {
  color: #6c757d;
  font-style: italic;
}

.form-control:disabled,
.form-control[readonly] {
  background-color: #fff;
  color: #6c757d;
}

/* Button */

.search-button-text {
  font-family: 'Poppins', sans-serif;
  font-weight: 500;
  font-size: 20px;
  text-transform: uppercase;
}

.flex-search {
  float: right;
}

@media only screen and (max-width: 575px) {
  .flex-search {
    float: left;
  }
}

/* Hide the search button next to "what on today" when the screen is small */

@media only screen and (max-width: 775px) {
  .dont-display2 {
    display: none;
  }
}

@media only screen and (min-width: 775px) {
  .dont-display1 {
    display: none;
  }
}

.btn-primary {
  background-color: #FF5733;
  border-style: none;
}

.btn-primary:visited {
  background-color: #900c3f;
}

.btn-primary:hover {
  color: #fff;
  background-color: #900c3f;
  border-color: #dc3545;
}

.badge-primary[href]:hover,
.badge-primary[href]:focus,
a.bg-primary:hover,
a.bg-primary:focus,
button.bg-primary:hover,
button.bg-primary:focus {
  background-color: #900c3f;
}

.btn-primary:focus,
.btn-primary.focus {
  background-color: #900c3f;
  box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
}

.btn-primary:not(:disabled):not(.disabled):active:focus,
.btn-primary:not(:disabled):not(.disabled).active:focus,
.show>.btn-primary.dropdown-toggle:focus {
  background-color: #900c3f;
  box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
}

.btn-primary:not(:disabled):not(.disabled):active,
.btn-primary:not(:disabled):not(.disabled).active,
.show>.btn-primary.dropdown-toggle {
  color: #fff;
  background-color: #900c3f;
  /* border-color: #b21f2d; */
  box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
}

.btn-primary:active,
.btn-primary.active {
  background-color: #900c3f;
}

/* Event description */

.event-description {
  text-align: left;
  padding-top: 6px;
}
</style>
