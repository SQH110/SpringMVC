<%@page pageEncoding="UTF-8" language="java" contentType="text/html;UTF-8" %>
<%--一排链接做实验用--%>
<a href="javascript:void(0);" id="testAjax">访问springmvc后台controller</a><br/>
<%--javascript:void(0);：表示点击的时候什么也不做--%>
<a href="javascript:void(0);" id="testAjaxPojo">访问springmvc后台controller，传递Json格式POJO</a><br/>
<a href="javascript:void(0);" id="testAjaxList">访问springmvc后台controller，传递Json格式List</a><br/>
<a href="javascript:void(0);" id="testAjaxReturnString">访问springmvc后台controller，返回字符串数据</a><br/>
<a href="javascript:void(0);" id="testAjaxReturnJson">访问springmvc后台controller，返回Json数据</a><br/>
<a href="javascript:void(0);" id="testAjaxReturnJsonList">访问springmvc后台controller，返回Json数组数据</a><br/>
<br/>
<a href="javascript:void(0);" id="testCross">跨域访问</a><br/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
    //设置页面加载事件
    $(function () {
        //为id="testAjax"的组件绑定点击事件
        $("#testAjax").click(function(){
            //发送异步调用
            $.ajax({/*通用的异步调用*/
               //请求方式：POST请求
               type:"POST",
               //请求的地址
               url:"ajaxController",
               //请求参数（也就是请求内容）
               data:'ajax message',//发送的数据
               //响应正文类型
               dataType:"text",
               //请求正文的MIME类型
               contentType:"application/text",
            });
        });

        //为id="testAjaxPojo"的组件绑定点击事件
        $("#testAjaxPojo").click(function(){
            $.ajax({
               type:"POST",
               url:"ajaxPojoToController",
               data:'{"name":"Jock","age":39}',//键值对的形式，json类型对象数据
               dataType:"text",
               contentType:"application/json",
            });
        });

        //为id="testAjaxList"的组件绑定点击事件
        $("#testAjaxList").click(function(){
            $.ajax({
               type:"POST",
               url:"ajaxListToController",
               data:'[{"name":"Jock","age":39},{"name":"Jockme","age":40}]',
               dataType:"text",
               contentType:"application/json",
            });
        });


        //为id="testAjaxReturnString"的组件绑定点击事件
        $("#testAjaxReturnString").click(function(){
            //发送异步调用
            $.ajax({
               type:"POST",
               url:"ajaxReturnString",
               //回调函数（页面上接收响应，使用回调函数）
               success:function(data){//data指服务端返回的数据
                    //打印返回结果
                    alert(data);
               }
            });
        });

        //为id="testAjaxReturnJson"的组件绑定点击事件
        $("#testAjaxReturnJson").click(function(){
            //发送异步调用
            $.ajax({
               type:"POST",
               url:"ajaxReturnJson",
               //回调函数
               success:function(data){
                    alert(data);
                    alert(data['name']+" ,  "+data['age']);
               }
            });
        });

        //为id="testAjaxReturnJsonList"的组件绑定点击事件
        $("#testAjaxReturnJsonList").click(function(){
            //发送异步调用
            $.ajax({
               type:"POST",
               url:"ajaxReturnJsonList",
               //回调函数
               success:function(data){
                    alert(data);
                    alert(data.length);
                    alert(data[0]["name"]);
                    alert(data[1]["age"]);
               }
            });
        });

        //为id="testCross"的组件绑定点击事件
        $("#testCross").click(function(){
            //发送异步调用
            $.ajax({
               type:"POST",
               // url:"cross",
               url:"http://www.jock.com/cross",//做跨域（把请求资源路径改到其他域名下）
               //回调函数
               success:function(data){
                   alert("跨域调用信息反馈："+data['name']+" , "+data['age']);
                   /*
                    里边是一个处理前台返回数据是对象的模式，和之前不做跨域处理返回单个pojo数据一样的
                   */
               }
            });
        });
    });
</script>