
$(document).ready(function(){
   

    $('.image_slider').slick({
       
        infinite: true,
        speed: 800,
        fade: true,
        cssEase: 'linear',
        autoplay: true,
        autoplaySpeed: 2000,


        prevArrow: `<button type='button' class='slick-prev slick-arrow'><i class="fa-solid fa-caret-left" style="color: #ffffff;"></i></button>`,
        nextArrow: `<button type='button' class='slick-next slick-arrow'><i class="fa-solid fa-caret-right" style="color: #ffffff;"></i></button>`
      });
              
       
  });
  



  var $grid = $('.collection-list').isotope({
    // options
  });
  // filter items on button click
  $('.filter-button-group').on( 'click', 'button', function() {
    var filterValue = $(this).attr('data-filter');
    resetFilterBtns();
    $(this).addClass('active-filter-btn');
    $grid.isotope({ filter: filterValue });
  });
  
  var filterBtns = $('.filter-button-group').find('button');
  function resetFilterBtns(){
    filterBtns.each(function(){
      $(this).removeClass('active-filter-btn');
    });
  }




/*nut tim kiem*/


document.addEventListener('DOMContentLoaded',function(){
	const searchIcon = document.getElementById('search-icon');
	const searchForm = document.getElementById('search-form');
	
	searchIcon.addEventListener('click',function(){
		if(searchForm.style.display === 'flex'){
			searchForm.style.display = 'none';
		}else{
			searchForm.style.display = 'flex';
		}
	})
})

