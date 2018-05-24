<template>
  <modal name="Reviews" transition="pop-out" :min-height="200" height="auto" width="60%">

    <!-- Section 1 -->
    <section class="modal-content" style="background-color:#fff">

        <div class="review-block" style="width:90%">
          <div class="row">
            <div class="col-sm-3">
              <img src="/static/assets/images/reviews/userface.jpg" style width="100">
              <div class="user-name"><a href="#">Graham</a></div>
              <div class="rating-date">March 10th 2018<br/>3 days ago</div>
            </div>

            <div class="col-sm-9">

              <div class="review-block-rate">
                  <span class="fa fa-star fa-2x checked"></span>
                  <span class="fa fa-star fa-2x checked"></span>
                  <span class="fa fa-star fa-2x checked"></span>
                  <span class="fa fa-star fa-2x checked"></span>
                  <span class="fa fa-star fa-2x"></span>
              </div>

              <div class="review-title">Perfect Hall, Spacious and Clean!</div>
              <div class="review-description">This hall was perfect, came with all facilities and everything was
                ready before we knew it. EventAR is perfect when it comes to booking venues. The event managers
                were really nice, all at a decent price too, will definetely reccoment it to anyone who needs to
                book a venue!
              </div>
            </div>
          </div>
          <hr/>

          <div class="row">
            <div class="col-sm-3">
              <img src="/static/assets/images/reviews/userface2.jpg" style width="100">
              <div class="user-name"><a href="#">Sam</a></div>
              <div class="rating-date">February 29 2018<br/>30 days ago</div>
            </div>
            <div class="col-sm-9">

              <div class="review-block-rate">
                <span class="fa fa-star fa-2x checked"></span>
                <span class="fa fa-star fa-2x checked"></span>
                <span class="fa fa-star fa-2x checked"></span>
                <span class="fa fa-star fa-2x checked"></span>
                <span class="fa fa-star fa-2x checked"></span>
              </div>

              <div class="review-title">Lavish Hall for Weddings!</div>
              <div class="review-description">This hall was perfect, came with all facilities and everything was
                ready before we knew it. EventAR is perfect when it comes to booking venues. Don't forget to ask
                for the caterers who did a lovely job with a nice menu. Personalised entrance, with decoration
                already set out, making it a perfect venue!
              </div>
            </div>
          </div>

          <hr/>
          <div class="row">
            <div class="review-form">
              <div class="review-box-title">Leave a Review</div>
              <br>Give a Rating out of 5
              <div class="rating">
                <span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
              </div>

              <div class="rate-text"><textarea placeholder="How was your experience?"
                                               style="height:50px"></textarea>

                <input type="submit" value="Submit"></div>
            </div>
          </div>
          <hr/>
        </div>
    
    </section>
  </modal>
</template>

<script>
  export default {
    name: 'Reviews',
    data () {
      return {}
    }
  }
</script>

<style scoped>
.modal-content {
    max-height: calc(100vh - 212px);
    overflow-y: auto;
}

  * {
    text-align: center;
  }

  /*REVIEWS*/
  .review-block {
    position: relative;
    padding: 50px;
    background-color: #f8f9fa;
    border: 1px solid #FF5733;
    border-radius: 3px;
    margin: auto;
  }

  .user-name {
    font-size: 15px;
    margin: 10px 0;
  }

  .rating-date {
    font-size: 12px;
  }

  .review-block-rate {
    font-size: 13px;
    margin-bottom: 15px;
  }

  .review-title {
    font-size: 17px;
    font-weight: 700;
    margin-bottom: 10px;
  }

  .review-box-title {
    text-align: center;
    font-size: 17px;
    font-weight: 700;
    margin-top: -15px;
    margin-bottom: -20px;
  }

  .review-description {
    font-size: 14px;
    text-align: justify;
  }

/*Inspiration for the Stars Animation - https://codepad.co/snippet/22fdD6wX*/

/*RATING STARS*/
  .rating {
    unicode-bidi: bidi-override;
    direction: rtl;
  }

  .rating > span {
    display: inline-block;
    position: relative;
    width: 1.1em;
  }

  .rating > span:hover:before,
  .rating > span:hover ~ span:before {
    content: "\2605";
    position: absolute;
  }

  .checked {
    color: #FFAE19;
  }


  /*COMMENT BOX*/  
  .rate-text {
    margin-top: 10px;
  }

  input[type=text], select, textarea {
    width: 100%; 
    padding: 12px;
    border: 1px solid #ccc; 
    border-radius: 4px;
    box-sizing: border-box; 
    margin-top: 6px; 
    margin-bottom: 16px;
    resize: vertical; 
  }


  input[type=submit] {
    position: center;
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }


  input[type=submit]:hover {
    background-color: #45a049;
  }


  .review-form {
    position: relative;
    border-radius: 5px;
    padding: 15px;
    width: 900px;
  }

</style>
