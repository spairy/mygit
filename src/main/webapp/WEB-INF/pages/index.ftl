<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body style="width:80%;">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
              </ul>
            </li>  
          </ul> 
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <br><br><br>
    <p>Current Time ${.now}</p>
	<h3>icon</h3>
	<span class="glyphicon glyphicon-home"></span>
    <span class="glyphicon glyphicon-signal"></span>
    <span class="glyphicon glyphicon-cog"></span>
    <span class="glyphicon glyphicon-apple"></span>
    <span class="glyphicon glyphicon-trash"></span>
    <span class="glyphicon glyphicon-play-circle"></span>
    <span class="glyphicon glyphicon-headphones"></span>
    
    <br/>
    <h3>button</h3>
    <button type="button" class="btn btn-default">button</button>
    <button type="button" class="btn btn-primary">primary</button>
    <button type="button" class="btn btn-success">success</button>
    <button type="button" class="btn btn-info">info</button>
    <button type="button" class="btn btn-warning">warning</button>
    <button type="button" class="btn btn-danger">danger</button>
    
    <br/>
    <h3>button size</h3>
    <button type="button" class="btn btn-default">button</button>
    <button type="button" class="btn btn-info btn-xs">small</button>
    <button type="button" class="btn btn-success btn-sm">normal</button>
    <button type="button" class="btn btn-primary btn-lg">so big</button>
	
	<br/>
    <h3>show icon inside button</h3>
    <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;button</button>
    
    <br/>
    <h3>dropdown list</h3>
    <div class="dropdown">
      <button class="btn btn-primary dropdown-toggle btn-xs" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
        Dropdown
        <span class="caret"></span>
      </button>
      <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Action</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Another action</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Something else here</a></li>
        <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Separated link</a></li>
      </ul>
    </div>
    
    <h3>input text box</h3>
    <div class="input-group">
      <span class="glyphicon glyphicon-user"></span>
      <input type="text" placeholder="username">
    </div>
    <div class="input-group">
      <span class="glyphicon glyphicon-lock"></span>
      <input type="password" placeholder="password">
    </div>
    
    <h3>form</h3>
    <form>
    <div class="form-group">
      <span class="glyphicon glyphicon-user"></span>
      <input type="email" id="exampleInputEmail1" placeholder="Enter email">
    </div>
    <div class="form-group">
      <span class="glyphicon glyphicon-lock"></span>
      <input type="password" id="exampleInputPassword1" placeholder="Password">
    </div>
    <div class="form-group">
      <label for="exampleInputFile">File input</label>
      <input type="file" id="exampleInputFile">
      <p class="help-block">Example block-level help text here.</p>
    </div>
    <div class="checkbox">
      <label>
        <input type="checkbox"> Check me out
      </label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
  
  <h3>warning box</h3>
    <div class="alert alert-warning alert-dismissible" role="alert">
       <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
       <strong>Warning!</strong> Better check yourself, you're not looking too good.
    </div>
    <div class="alert alert-success" role="alert">
        <a href="#" class="alert-link">success!</a>
    </div>
    <div class="alert alert-info" role="alert">
        <a href="#" class="alert-link">info!</a>
    </div>
    <div class="alert alert-warning" role="alert">
        <a href="#" class="alert-link">warning!</a>
    </div>
    <div class="alert alert-danger" role="alert">
        <a href="#" class="alert-link">danger!</a>
    </div>
    
    <h3>loading...</h3>
    <div class="progress">
      <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
        70%
      </div>
    </div>
</body>
<#include "/common/common.ftl"/>
</html>