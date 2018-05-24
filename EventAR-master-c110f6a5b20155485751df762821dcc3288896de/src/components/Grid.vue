<template>
  <div class="mainDisplay">
  <section>

    <!-- Slideshow arrows -->
    <svg class="hidden">
    <symbol id="icon-arrow" viewBox="0 0 24 24">
      <title>arrow</title>
      <polygon points="6.3,12.8 20.9,12.8 20.9,11.2 6.3,11.2 10.2,7.2 9,6 3.1,12 9,18 10.2,16.8 "/>
    </symbol>

    <symbol id="icon-nav-arrow" viewBox="0 0 24 17">
      <title>nav arrow</title>
      <polygon points="14.1333333 2.61666667 18.9333333 7.41666667 0 7.41666667 0 10.0833333 18.9333333 10.0833333 14.1333333 14.8833333 16 16.75 24 8.75 16 0.75"></polygon>
    </symbol>
    </svg>

    <div class="jumbotron-xs">
      <div class="container">
        <div class="row ">
          <div class="col-xs-12">
            <div class="section-grid-photos">
              <div class="grid grid--layout-1 grid--current">
                <div class="grid__item "></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item grid__item--nav grid__item--nav-prev">
                  <svg class="icon icon--nav-arrow"><use xlink:href="#icon-nav-arrow"></use></svg>
                </div>
                <div class="grid__item grid__item--nav grid__item--nav-next">
                  <svg class="icon icon--nav-arrow"><use xlink:href="#icon-nav-arrow"></use></svg>
                </div>
                <h2 class="grid__item grid__item--name">discover <br />and plan</h2>
                <h3 class="grid__item grid__item--title">Events</h3>
                <p class="grid__item grid__item--text"></p>
              </div>
              <div class="grid grid--layout-2">
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item grid__item--nav grid__item--nav-prev">
                  <svg class="icon icon--nav-arrow"><use xlink:href="#icon-nav-arrow"></use></svg>
                </div>
                <div class="grid__item grid__item--nav grid__item--nav-next">
                  <svg class="icon icon--nav-arrow"><use xlink:href="#icon-nav-arrow"></use></svg>
                </div>
                <h2 class="grid__item grid__item--name">create <br />and <br />explore</h2>
                <h3 class="grid__item grid__item--title">packages</h3>
                <p class="grid__item grid__item--text"></p>
              </div>
              <div class="grid grid--layout-3">
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item"></div>
                <div class="grid__item grid__item--nav grid__item--nav-prev">
                  <svg class="icon icon--nav-arrow"><use xlink:href="#icon-nav-arrow"></use></svg>
                </div>
                <div class="grid__item grid__item--nav grid__item--nav-next">
                  <svg class="icon icon--nav-arrow"><use xlink:href="#icon-nav-arrow"></use></svg>
                </div>
                <h2 class="grid__item grid__item--name">provide <Br />vendors</h2>
                <h3 class="grid__item grid__item--title">see more</h3>
                <p class="grid__item grid__item--text"></p>
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- END OF GRID PHOTOS -->

  <!-- DESCRIPTION BLOCKS - Plan, Discover, Vend -->
  <section id="services ">
    <div class="container icon-description">

      <div class="row ">
        <div class="col-xs col-md-3 mx-auto ">
          <div data-aos="zoom-in" data-aos-delay="100" class="hvr-underline-from-left">
            <h2 class="sub-heading ">Plan</h2>
            <p class="description ">A stress-free, timely and cost-effecient way to organise your event the way you envision it. Helping you find exactly what you need to run your event successfully.</p>
          </div>
        </div>

        <div class="block col-xs col-md-3 mx-auto ">
          <div data-aos="zoom-in" data-aos-delay="300" class="hvr-underline-from-left">
            <h2 class="sub-heading ">Discover</h2>
            <p class="description ">Never miss out on new experiences. Showing you museums, restaurants, festivals and events that meet your interests and are taking place near you.</p>
          </div>
        </div>

        <div class="block col-xs col-md-3 mx-auto ">
          <div data-aos="zoom-in" data-aos-delay="500" class="hvr-underline-from-left">
            <h2 class="sub-heading ">Vend</h2>
            <p class="description ">Promote your business through advertising. Help planners check off their list of vendors needed by reaching out and delievering your service. </p>
          </div>
        </div>
      </div>

    </div>
  </section>
  </div>
</template>

<script>
export default {
  name: 'Grid',
  mounted () {
    const DOM = {}
    DOM.body = document.body
    DOM.gridElems = Array.from(document.querySelectorAll('.grid'))

    imagesLoaded(
      DOM.body,
      {
        background: true
      },
      () => {
        DOM.body.classList.remove('loading')
        new Slideshow(DOM.gridElems)
      })
  }
}
</script>

<style scoped>
  .main {
  }
</style>
