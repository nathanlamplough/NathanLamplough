<script>
var acc = document.getElementsByClassName('accordion')
var i

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener('click', function () {
    this.classList.toggle('active')
    var panel = this.nextElementSibling
    if (panel.style.display === 'block') {
      panel.style.display = 'none'
    } else {
      panel.style.display = 'block'
    }
  })
}
</script>
<template>
  <section id="packages " class="bg-light ">
    <div class="container ">

      <div class="row ">
        <div class="col-xs col-lg-12" data-aos="fade-right">
          <div class="hvr-underline-from-left">
            <h1 class="section-heading">Search</h1>
          </div>
        </div>
      </div>

      <br />

            <!-- Discover Events -->

      <div class="row ">
        <div class="col-xs-12 col-md-6">
  <button class="accordion"><h2 class="discover-title">Discover Events</h2></button>

  <div class="panel">
              <!-- location -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Location</label></h5>
                <input class="form-control" type="text" placeholder="Where are you looking for an event?">
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
                  <input class="form-control" size="16" type="text" value="When would you like to go?" readonly>
                  <span class="add-on"><i class="icon-remove"></i></span>
                  <span class="add-on"><i class="icon-th"></i></span>
                </div>
                <input class="form-control" type="hidden" id="dtp_input2" value="" />
                <!-- <br/> -->
              </div>
              <hr />

              <!-- interest -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Interests</label></h5>
                <input class="form-control" type="text" placeholder="What are you interested in?">
                <div class="instruction">
                  (Check the boxes)
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                Art
              </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Bars
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Restaurants
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Sport and fitness
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Theatre
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Clubs
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Museums
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Live Music
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Attractions
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Comedy
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Outdoor Activities
                </label>
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                  <label class="form-check-label" for="defaultCheck1">
                  Indoor Activities
                </label>
                </div>
              </div>
              <hr />

              <!-- Price range -->
              <div class="form-group">
                <h5><label for="exampleFormControlSelect2">Price range</label></h5>
                <div data-role="main" class="ui-content">
                  <form method="post">
                    <div data-role="rangeslider">
                      <label for="price-min">£0</label>
                      <input type="range" name="price-min" id="price-min" value="200" min="0" max="1000">
                      <label for="price-max">£1000</label>
                    </div>
                  </form>
                </div>
              </div>

          <button type="button" class="btn btn-primary">Search</button>
</div>

<br /><br />
<figure class="figure">
  <img src="/static/assets/images/plan/3.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
</figure>
          </div>



      <!-- End of Discover -->


      <!-- Plan Events -->
  <div class="col-xs-12 col-md-6">
<button class="accordion"><h2 class="plan-title">Plan Events</h2></button>
<div class="panel">
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
<button type="button" class="btn btn-primary">Search</button>
</div>
<br /><br />
<figure class="figure">
  <img src="/static/assets/images/plan/ceremony.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
</figure>
</div>

</div>
</div>

      <!-- End of Plan -->


    </div>
  </section>
</template>

<style>
body {
  font-family: 'Poppins', sans-serif;
}
/* SEARCH */

.discover-title, .plan-title {
  font-weight: 600;
  font-family: 'Poppins', sans-serif;
    color: #900c3f;
}

.btn {
  font-family: 'Poppins', sans-serif;
  font-weight: 500;
}

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

/* Accordian */
.accordion {
    background-color: #eee;
    color: #444;
    cursor: pointer;
    padding: 18px;
    width: 100%;
    border: none;
    text-align: left;
    outline: none;
    font-size: 15px;
    transition: 0.4s;
}

.active, .accordion:hover {
    background-color: #ccc;
}

.panel {
    padding: 0 18px;
    display: none;
    background-color: white;
    overflow: hidden;
}
</style>

<script>
var acc = document.getElementsByClassName('accordion')
var i

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener('click', function () {
    this.classList.toggle('active')
    var panel = this.nextElementSibling
    if (panel.style.display === 'block') {
      panel.style.display = 'none'
    } else {
      panel.style.display = 'block'
    }
  })
}
</script>
