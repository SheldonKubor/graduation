/**
 * Created by Constantine on 2017/3/16.
 */
function display(id) {

     var obj=document.getElementById(id);
    //
    // if (obj.style.display="none"){
    //     obj.style.display="block";
    // }else if (obj.style.display="block"){
    //     obj.style.display="none";
    // }
    obj.style.display=(obj.style.display=="none")?"block":"none";
}