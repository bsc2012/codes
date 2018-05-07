<!DOCTYPE html>
<HTML>
 <HEAD>
  <TITLE> ZTREE DEMO </TITLE>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="jquery/zTree_v3/css/demo.css" type="text/css">
  <link rel="stylesheet" href="jquery/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
  <script type="text/javascript" src="jquery/zTree_v3/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="jquery/zTree_v3/js/jquery.ztree.core.min.js"></script>
  <SCRIPT LANGUAGE="JavaScript">
   var zTreeObj;
   var setting = {};
   var zNodes = [
   {name:"test1", open:true, children:[
      {name:"test1_1"}, {name:"test1_2"}]},
   {name:"test2", open:true, children:[
      {name:"test2_1"}, {name:"test2_2"}]}
   ];
   $(document).ready(function(){
      zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
   });
  </SCRIPT>
 </HEAD>
<BODY>
<div>
   <ul id="treeDemo" class="ztree"></ul>
</div>
</BODY>
</HTML>