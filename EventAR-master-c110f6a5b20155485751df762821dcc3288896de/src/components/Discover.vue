<template>
<div class="discover" style="padding-top:100px">

    <!-- Section 1 -->
    <section style="background-color:#fff">
        <div class="container ">

            <div class="row ">
                <div class="col-xs-12 col-sm-6" data-aos="fade-right">
                    <div class="hvr-underline-from-left">
                        <h1 class="section-heading">Discover</h1>
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
                            <h5 class="modal-title" id="exampleModalLongTitle">Discover</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
                        </div>

                        <div class="modal-body">

                            <!-- location -->
                            <div class="form-group">
                                <h5><label for="exampleFormControlSelect2">Location</label></h5>
                                <input id="pac-input" class="controls" type="text" placeholder="Enter a location">
                                <div class="map":id="mapName" ></div>
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
                    <h2 class="subheading">What's on Today?</h2>
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
                <div class="scrollmenu">
                    <br />
                    <figure class="figure">
                        <img src="/static/assets/images/plan/1.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/2.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/3.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/4.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/1.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/2.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/3.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/gym.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                </div>
            </div>

            <br /><br />

            <div class="row ">
                <div class="col-lg-12">
                    <h2 class="subheading">Things to do Near You</h2>
                </div>
                <div class="scrollmenu">
                    <br />
                    <figure class="figure">
                        <img src="/static/assets/images/plan/11.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/22.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/family.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/44.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/meeting.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/caterer.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/florist.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/3.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                </div>
            </div>

            <br /><br />

            <div class="row ">
                <div class="col-lg-12 mx-auto ">
                    <h2 class="subheading">Upcoming Events in London</h2>
                </div>
                <div class="scrollmenu">
                    <br />
                    <figure class="figure">
                        <img src="/static/assets/images/plan/party.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/pr.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/ceremony.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/plan/exhibition.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/1.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/2.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/3.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                    <figure class="figure">
                        <img src="/static/assets/images/discover/4.jpg" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                        <figcaption class="figure-caption"><span class="flex-left">Event Name</span> <span class="flex-right">Price</span><br /> <span class="brief-description">A brief description about the event.</span></figcaption>
                    </figure>
                </div>
            </div>
        </div>
    </section>


    <!-- Section 2 -->
    <section class="bg-light ">
        <div class="container ">

            <div class="row ">
                <div class="col-xs col-lg-12" data-aos="fade-right">
                    <div class="hvr-underline-from-left">
                        <h1 class="section-heading">Best of london</h1>
                    </div>
                </div>
            </div>
            <br />

            <div class="row ">
                <div class="col-lg-12 mx-auto ">
                    <h2 class="subheading">Discover the best museums, galleries, cafe's, restaurants, theatre, workshops in and around London</h2>
                </div>
            </div>
        </div>
    </section>

</div>
</template>

<script>
export default {
  name: 'google-map',
  props: ['name'],
  data: function () {
    return {
      mapName: this.name + '-map',
      markerCoordinates: [{
        latitude: 51.501527,
        longitude: -0.1921837
      }],
      map: null,
      bounds: null,
      markers: []
    }
  },
  mounted: function () {
    this.bounds = new google.maps.LatLngBounds()
    const element = document.getElementById(this.mapName)
    const mapCentre = this.markerCoordinates[0]
    const options = {
      center: new google.maps.LatLng(mapCentre.latitude, mapCentre.longitude)
    }
    this.map = new google.maps.Map(element, options)
    this.markerCoordinates.forEach((coord) => {
      const position = new google.maps.LatLng(coord.latitude, coord.longitude)
      const marker = new google.maps.Marker({
        position,
        map: this.map
      })
      this.markers.push(marker)
      this.map.fitBounds(this.bounds.extend(position))
    })
  }
}
</script>

<style scoped>
/* DISCOVER PAGE CSS */


/* NAVIGATION */

body {
    margin-top: 100px;
}

.flex-left {
    float: left;
}

.flex-right {
    float: right;
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

.figure-img {
    height: 214px;
}

.figure-img:hover {
    padding: 2px;
    border: 2px solid #bbb;
}

.brief-description {
    font-weight: 100;
    color: gray;
    font-size: 14px;
}


/* SUBHEADING */

.subheading {
    font-size: 30px;
    color: #900c3f;
    padding-bottom: 20px;
    border-style: none;
    font-family: 'Poppins', sans-serif;
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

.map {
    width: 450px;
    height: 300px;
    margin: 0 auto;
    background: gray;
}


/* Always set the map height explicitly to define the size of the div
      * element that contains the map. */
     #map {
       height: 100%;
     }
     /* Optional: Makes the sample page fill the window. */
     html, body {
       height: 100%;
       margin: 0;
       padding: 0;
     }
     #description {
       font-family: Roboto;
       font-size: 15px;
       font-weight: 300;
     }

     #infowindow-content .title {
       font-weight: bold;
     }

     #infowindow-content {
       display: none;
     }

     #map #infowindow-content {
       display: inline;
     }

     .pac-card {
       margin: 10px 10px 0 0;
       border-radius: 2px 0 0 2px;
       box-sizing: border-box;
       -moz-box-sizing: border-box;
       outline: none;
       box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
       background-color: #fff;
       font-family: Roboto;
     }

     #pac-container {
       padding-bottom: 12px;
       margin-right: 12px;
     }

     .pac-controls {
       display: inline-block;
       padding: 5px 11px;
     }

     .pac-controls label {
       font-family: Roboto;
       font-size: 13px;
       font-weight: 300;
     }

     #pac-input {
       background-color: #fff;
       font-family: Roboto;
       font-size: 15px;
       font-weight: 300;
       margin-left: 12px;
       padding: 0 11px 0 13px;
       margin-bottom: 10px;
       text-overflow: ellipsis;
       width: 440px;
     }

     #pac-input:focus {
       border-color: #4d90fe;
     }

     #title {
       color: #fff;
       background-color: #4d90fe;
       font-size: 25px;
       font-weight: 500;
       padding: 6px 12px;
     }
     #target {
       width: 345px;
     }
</style>
