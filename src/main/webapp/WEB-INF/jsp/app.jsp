<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Integracja systemów - laboratorium 6</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
    
</head>
<body>

    <div class="container">
    
    	<nav class="navbar navbar-light bg-faded">
		  <a class="navbar-brand" href="#">Pobieranie danych</a>
		  <form class="form-inline float-xs-right" th:action="@{/logout}" method="post">
		    <a href="styles" class="btn btn-outline-success" role="button">Pobierz style</a>
		    <button class="btn btn-outline-success" type="submit">Wyloguj się</button>
		  </form>
		</nav>

    
    	<div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
	    	<form th:case="false" class="form-group" action="#" th:action="@{/errorMsg}" method="get">
		    	<hr/>
				<fieldset>
				<!-- Text input-->
				<div class="form-group">
				  <label class="col-md-10 control-label"><font color="red">Możesz pobierać dane co 5 sekund.</font></label>  
				  <div class="col-md-2">
				  	<button type="submit" class="btn btn-outline-success" style="float:right">Odśwież</button>
				  </div>
				</div>
				</fieldset>
			</form>
		</div>
		
		
		
		<form class="form-group" action="#" th:action="@{/downloadFormat}" th:object="${downloadFormat}" method="post">
			<hr/>
			<fieldset>
			<!-- Text input-->
			<div class="form-group"> 
				 <label class="col-md-5 control-label" >Wybierz format w jakim chcesz pobierać dane:</label>  
				<div class="col-md-5">
				 <div class="btn-group" data-toggle="buttons">
				  <label  class="radio-inline">
				    <input th:field="*{search}" type="radio" name="options" value="XML" autocomplete="off" checked="true"/> XML (domyślnie)
				  </label>
				  <label  class="radio-inline">
				    <input th:field="*{search}"  type="radio" name="options" value="YAML" autocomplete="off"/> YAML
				  </label>
				  <label  class="radio-inline">
				    <input th:field="*{search}"  type="radio" name="options" value="OGDL" autocomplete="off"/> OGDL
				  </label>
				  <label  class="radio-inline">
				    <input th:field="*{search}"  type="radio" name="options" value="JSON" autocomplete="off"/> JSON
				  </label>
				</div>
			  </div>
			  <div   class="col-md-2"> 
				  <button  style="float:right" type="submit" class="btn btn-outline-success"> Zmień </button>
			  </div>
			</div>
			
			</fieldset>
			
			
		</form>
		

	    <form class="form-group" action="#" th:action="@{/gameName}" th:object="${gameName}" method="post">
	    	<hr/>
			<fieldset>
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-5 control-label" >Wyszukaj gry zawierające w nazwie:</label>  
			  <div class="col-md-5">
			  	<input type="text" th:field="*{search}" placeholder="szukany tekst" name="gameNamePhrase" class="form-control input-md" required="true"/>
			  </div>
			  <div   class="col-md-2" th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button style="float:right"  title="Możesz pobierać dane raz na 15 sekund." th:case="false" type="submit" disabled="true" class="btn btn-outline-success pull-right">Pobierz</button>
			  </div>
			</div>
			
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/gameDeck}" th:object="${gameDeck}" method="post">
			<fieldset>
			<div class="form-group">
			  <label class="col-md-5 control-label" >Wyszukaj gry zawierające w opisie:</label>  
			  <div class="col-md-5">
			  	<input type="text" th:field="*{search}"  placeholder="szukany tekst" name="gameNamePhrase" class="form-control input-md" required="true"/>
			  </div>
			  <div class="col-md-2">
			  	<div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button style="float:right" title="Możesz pobierać dane raz na 15 sekund." th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			
			</fieldset>
			<hr/>
		</form>
		
		
		<form class="form-group" action="#" th:action="@{/platforms}" th:object="${platforms}" method="post">
			<fieldset>
			<!-- Text input-->
			<div class="form-group" >
			  <label class="col-md-5 control-label " >Wyszukaj gry na platformach:</label>  
			  <div class="col-md-5">
			  	<label class="form-check-inline">
				  <input th:field="*{pc}" class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1"/> PC
				  <span class="glyphicon glyphicon-ok"></span>
				</label>
				<label class="form-check-inline">
				  <input th:field="*{arcade}" class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2"/> ARC
				</label>
				<label class="form-check-inline">
				  <input th:field="*{xbox}" class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3"/> XBX
				</label>
				<label class="form-check-inline">
				  <input th:field="*{playstation}" class="form-check-input" type="checkbox" id="inlineCheckbox4" value="option4"/> PS
				</label>
			  </div>
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" title="Możesz pobierać dane raz na 15 sekund." th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			</fieldset>
			
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/reviewsNumber}" th:object="${reviewsNumber}" method="post">
			<fieldset>
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-5 control-label" >Wyszukaj gry z liczbą recenzji większą niż:</label>  
			  <div class="col-md-5">
			  	<input type="number" th:field="*{search}"  placeholder="podaj minimalną liczbę recenzji" name="gameNamePhrase" class="form-control input-md" required="true"/>
			  </div>
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" title="Możesz pobierać dane raz na 15 sekund." th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/releaseYear}" th:object="${releaseYear}" method="post">
			<fieldset>
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-5 control-label" >Wyszukaj gry wydane w roku:</label>  
			  <div class="col-md-5">
			  	<input type="number" th:field="*{search}" min="1960" max="2020"  placeholder="podaj rok wydania gry" name="gameNamePhrase" class="form-control input-md" required="true"/>
			  </div>
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" title="Możesz pobierać dane raz na 15 sekund." th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/addYear}" th:object="${addYear}" method="post">
			<fieldset>
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-5 control-label" >Wyszukaj wpisy dodane do bazy danych w roku:</label>  
			  <div class="col-md-5">
			  	<input type="number" th:field="*{search}" min="1960" max="2020"  placeholder="podaj rok dodania do bazy" name="gameNamePhrase" class="form-control input-md" required="true"/>
			  </div>
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" title="Możesz pobierać dane raz na 15 sekund." th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			
			</fieldset>
			<hr/>
		</form>
		
		
		<form class="form-group" action="#" th:action="@{/platformPC}" method="post">
			<fieldset>
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-10">
			    <label>Wyszukaj gry na PC</label>
			  </div>
			  
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/platformPS}" method="post">
			<fieldset>
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-10">
			    <label>Wyszukaj gry na Playstation:</label>
			  </div>
			  
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button style="float:right"  th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/platformARCADE}" method="post">
			<fieldset>
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-10">
			    <label>Wyszukaj gry na automaty:</label>
			  </div>
			  
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button style="float:right"  th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/platformXBOX}" method="post">
			<fieldset>
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-10">
			    <label>Wyszukaj gry na XBOX:</label>
			  </div>
			  
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button  style="float:right" th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			</fieldset>
			<hr/>
		</form>
		
		<form class="form-group" action="#" th:action="@{/logs}" method="post">
			<fieldset>
			<!-- Button -->
			<div class="form-group">
			  <div class="col-md-10">
			    <label>Pobierz logi:</label>
			  </div>
			  
			  <div class="col-md-2">
			    <div th:switch="${T(beans.AppHelper).isYouCanGrabData()}"> 
				  <button style="float:right"  th:case="true" type="submit" class="btn btn-outline-success">Pobierz</button>
				  <button  style="float:right" th:case="false" type="submit" disabled="true" class="btn btn-outline-success">Pobierz</button>
				</div>
			  </div>
			</div>
			</fieldset>
			<hr/>
		</form>
		
		
    </div>
    
</body>
</html>
