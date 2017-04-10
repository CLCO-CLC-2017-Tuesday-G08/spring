	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
	
	<t:template>
		<jsp:body>		
					</tr><tr valign="top">
			<td><div id="pnCenter">
				<div id="pnCenterDisplay" style="width:692px;float:left">
					<div id="indexMain" style="float:left;"><div>
						<style>
	</style>
	<div id="main">
	<div id="head">
	</div>
	<div id="head-link">
	</div>
	<div id="left">
	</div>
	<div id="content">
	</div>
	<div id="right">
	</div>
	<div id="footer">
	</div>
	</div>
	
	<script src="editor/ckeditor.js" language="javascript"></script>
	
					</div></div><div id="news" style="float:left;"><div>
						<p class="MsoNormal" style="margin: 6pt 0cm 0.0001pt; text-align: justify;">
	</p><table style="text-align: justify;">
	 <!--  tbody -->
	  <tbody>
	
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Description</label>
							<div class="col-md-7">
								<form:input type="text" path="description" id="description" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
					<script type="text/javascript" language="javascript">

CKEDITOR.replace( 'description' );

</script> 
			
				
</tbody>
	    
	     <!--  end tbody -->
	</table>
	<br>
	<br>
	<p></p>
	
					</div></div>
				</div>
			
		</jsp:body>
	</t:template>