$(document).ready(function() {


$('.dynamic-content').load('content/overview.html') ;


    var old='overview'  ;
    var oldb='maxh' ;
  $('ul#sidenav  a').click(function(){

      $(".loader-inner").addClass("ball-pulse");
      var page = $(this).attr('href') ;

      setTimeout(function () {
        $('.dynamic-content').load('content/'+ page +'.html') ;
        $(".loader-inner").removeClass("ball-pulse");
      }, 1500);
      $('#'+old).removeClass('active');
      $('#'+page).addClass('active');
      old=page ;

      return false ;
  });


  $(document.body).on('click', '.azi' ,function(){
     var bolder =  $(this).attr('href')  ;
     var oldbering = oldb.replace('h' , '') ;
     var boldering =  bolder.replace('h', '') ;
     $('.'+oldb).removeClass('active') ;
     $('.'+bolder).addClass('active') ;
     $('.'+oldb+'c').removeClass('colorstrip-'+oldbering) ;
     $('.'+bolder+'c').addClass('colorstrip-'+boldering) ;
     oldb = bolder ;
     return false;
 });


 $(document.body).on('change',  '.disease', function(){
   var district =  this.value ;
   $('.diseasegraph').empty() ;
   $('.diseasegraph').html("<img src='http://prokart.helpkart.in/graphs/"+district+".png' />") ;
 });

 $(document.body).on('change',  '.habits', function(){
   var district =  this.value ;
   $('.habitsgraph').empty() ;
   $('.habitsgraph').html("<img src='http://prokart.helpkart.in/graphs/"+district+".png' />") ;
 });


});
