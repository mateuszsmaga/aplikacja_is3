<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Style</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    
</head>
<body>

    <div class="container">
    
    	<nav class="navbar navbar-light bg-faded">
		  <a class="navbar-brand" href="#">Pobieranie styli</a>
		  <div class="form-inline float-xs-right">
		    <a href="app" class="btn btn-outline-success" role="button">Pobierz dane</a>
		  </div>
		</nav>
		
		<form class="form-group" action="#" th:action="@{/getColours}" th:object="${getColours}" method="post">
	    	<hr/>
			<fieldset>
			<!-- Text input-->
			<div class="form-group">
			  <h3 class="col-md-12 control-label">Spersonalizowany css:</h3>  
			  <div>
			  	<label class="col-md-10 control-label">Tło pliku xml:</label>
			  	<input class="col-md-2" type="color" th:field="*{backgroundColour}" name="bckg" value="#d7eef2"/>
			  	<label class="col-md-10 control-label">Tło tabeli:</label>
			  	<input class="col-md-2" type="color" th:field="*{tableBackground}" name= "text" value="#ff0000"/>
			  	<label class="col-md-10 control-label">Tło nieparzystych wierszy:</label>
			  	<input class="col-md-2" type="color" th:field="*{evenColour}" name= "text" value="#ff0000"/>
			  	<label class="col-md-10 control-label">Kolor kropek na krawędziach tabeli:</label>
			  	<input class="col-md-2" type="color" th:field="*{outlineColour}" name= "text" value="#ff0000"/>
			  	<label class="col-md-10 control-label">Nagłówek pliku xml:</label>
			  	<input class="col-md-2" type="color" th:field="*{firstLineColour}" name="fline" value="#ff0000"/>
			  	<label class="col-md-10 control-label">Kolor po naciśnięciu LPM:</label>
			  	<input class="col-md-2" type="color" th:field="*{activeColour}" name="active" value="#f1c2fc"/>
			  	<label class="col-md-10 control-label">Kolor po najechaniu myszą:</label>
			  	<input class="col-md-2" type="color" th:field="*{hoverColour}" name= "hover" value="#85bc86"/>
			  	<label class="col-md-10 control-label">Kolor tekstu:</label>
			  	<input class="col-md-2" type="color" th:field="*{textColour}" name= "text" value="#ff0000"/>
			  	<label class="col-md-10 control-label">Styl tekstu:</label>
			  	<div class="col-md-2 btn-group float-xs-right" data-toggle="buttons">
				  <label  class="radio-inline">
				    <input checked="true" th:field="*{fontStyle}" type="radio" name="options" value="normal" autocomplete="off"/> normal
				  </label>
				  <label  class="radio-inline">
				    <input th:field="*{fontStyle}"  type="radio" name="options" value="italic" autocomplete="off"/> italic
				  </label>
				</div>
				<label class="col-md-10 control-label">Rozmiar tekstu:</label>
			    <input class="col-md-2" type="number" th:field="*{fontSize}" min="50" max="150"  placeholder="rozmiar czcionki" required="true"/>
			  </div>
			  
			  <div> 
				  <button style="margin-top: 5px" class="col-md-12 btn btn-outline-success" type="submit" >Pobierz</button>
			  </div>
			</div>					
			</fieldset>
			<hr/>
		</form>
		
		<h3 class="col-md-12 control-label">Gotowe pliki css:</h3>  
		<form class="form-group" action="#" th:action="@{/templateThree}" method="post">
			<button class="col-md-4 btn btn-outline-success" style="float:right" type="submit" >Template#3</button>
		</form>
		<form class="form-group" action="#" th:action="@{/templateTwo}" method="post">
			<button class="col-md-4 btn btn-outline-success" style="float:right" type="submit" >Template#2</button>
		</form>
		<form class="form-group" action="#" th:action="@{/templateOne}" method="post">
			<button class="col-md-4 btn btn-outline-success" style="float:right" type="submit" >Template#1</button>
		</form>
		<hr/>
    </div>
    
</body>
</html>
