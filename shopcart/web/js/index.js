$(document).ready(function () {
   $.ajax({
       type:"POST",
       url:"queryAll.action",
       success:function (data) {

        let json=JSON.parse(data);
        console.log(data);
        if (json.flag=="666"){
            $.each(json.object,function (index,item) {
                $(".products").append(
                "<div class='product'>"+
                    "<div>商品图片</div>"+
                    "<div>"+item.name+"</div>"+
                    "<div>"+item.price+"&nbsp;"+item.dicount+"</div>"+
                    "<div><button type='button' onclick='addToCart("+item.id+");'>加入购物车</button></div>"+
                "</div>"
                )
                
            });
        }else{
            alert(error)
        }
       },
       error:function (error) {
           alert(error)
       }
   });
});
function addToCart(pid) {
    $.ajax({
        type: "POST",
        url:"addToCart.action",
        data:{
            //冒号左边的pid是要和主控制器保持一致，冒号右边的pid是js函数addToCart(pid)的形参
            pid:pid
        },
        success:function (data) {
            console.log(data+"--------------------------------------------10101010");
            let json=JSON.parse(data);
            console.log("1010101010101010101010101010"+data);
            if (json.flag!="666"){
                alert("添加失败！-----"+json.flag);
            }else{
                alert("添加成功");
            }
        },
        error:function (error) {
            alert(error);
        }
    });
}