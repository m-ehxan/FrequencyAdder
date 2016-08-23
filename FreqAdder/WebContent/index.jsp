<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Frequency Adder</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div>
			<br>
			<header> Frequency Adder Web App </header>
		</div>
		<div class="outer">
			<div class="inner">
				<form action="FreqServlet" method="post"> 
					<h1>Frequency Adder</h1> 
                       <button class="button" type="submit" name="btn" value="Generate">Generate</button> &nbsp; &nbsp; &nbsp;
                       <button class="button" type="submit" name="btn" value="PlayorFile">Play or File</button>
                       <br><br>

						Signal: <select name="Signal">
  								<option value="Sine">Sine</option>
  								<option value="Triangle">Triangle</option>
  								<option value="Square">Square</option>
  								<option value="Sawtooth">Sawtooth</option>
						</select> &nbsp;&nbsp;
						<input type="radio" name="selection" value="Frequency1" checked="checked"> Frequency 1 &nbsp; &nbsp;
                        <input type="radio" name="selection" value="Frequency2"> Frequency 2 &nbsp; &nbsp;
						<input type="radio" name="selection" value="Sum"> Sum  
						<br><br>
 						Frequency 1: <input type="number" name="First Freq" value="0" min="1" max="48000"> Hz &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  
						Frequency 2: <input type="number" name="Second Freq" value="0" min="1" max="48000"> Hz &nbsp; &nbsp; &nbsp; 
						
						<br><br>
						Sampling Rate:
						<select name="Sample">
							<option value="8">8</option>
  							<option value="16" >16</option>
  							<option value="22.05">22.05</option>
  							<option value="32">32</option>
  							<option value="44.1" selected="selected">44.1</option>
  							<option value="48">48</option>
  							<option value="88.2">88.2</option>
 	 						<option value="96">96</option>
						</select> &nbsp;  &nbsp;
						
						Amplitude: <input type="number" name="Amplitude" value="1" min="1" max="10"> &nbsp; &nbsp; &nbsp;
						Duration: <input type="number" name="Duration" value="4" disabled> seconds &nbsp;&nbsp;
						<br><br>
						
				</form>
				<form action="FreqServlet" method="post">
                                <input type="radio" name="action" value="Listen" checked="checked"> Listen &nbsp; &nbsp;
                                <input type="radio" name="action" value="File"> File &nbsp; &nbsp;
                                <input type="text" name="Filename" placeholder="Enter Name">
                </form>
			</div>
		</div>
	</body><h1></h1>

<h1></h1>

<h2></h2>

</html>