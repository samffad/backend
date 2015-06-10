/**
 * Created with IntelliJ IDEA.
 * User: 20086088
 * Date: 2014/12/28
 * Time: 10:09
 */
var nav = function(){
  return {
    active:function(navId){
      if(navId){
        $("#navBar li").removeClass("active");
        $("#"+navId).addClass("active");
      }
    },
    getMeta:function(metaName){
      var meta = $("meta[name="+metaName+"]");
      return meta?meta.attr("content"):"";
    }
  };
}();


$(function(){
  nav.active("nav_"+nav.getMeta("activebar"));
});