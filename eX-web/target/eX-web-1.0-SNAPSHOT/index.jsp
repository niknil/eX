<!DOCTYPE html>
<html>
<head>

  <title>SuperHero Wiki</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <link href="css/eX.css" rel="stylesheet"/>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular-route.js"></script>
  <script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js"></script>

  <!-- bootstrapping -->
  <script src="eX/eXApp.js"></script>

  <!-- Modules -->
  <script src="eX/core/service/service.module.js"></script>
  <script src="eX/core/routing/route.module.js"></script>
  <script src="eX/core/directive/directive.module.js"></script>
  <script src="eX/core/core.module.js"></script>
  <script src="eX/team/team.module.js"></script>
  <script src="eX/heroes/heroes.js"></script>


  <!-- Controllers -->
  <script src="eX/heroes/hero.js"></script>
  <script src="eX/team/team.js"></script>

  <!-- Services -->
  <script src="eX/core/service/service.js"></script>
  <script src="eX/core/routing/route.js"></script>
  <script src="eX/core/directive/directive.js"></script>


  <script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}"
  </script>

</head>

<div id="mainmenu">
    <img id="banner" src="images/banner.jpg" alt="Banner Image"/>
</div>

<body ng-app="app" >

<div id="cointainer">
  <nav class="navbar navbar-default">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Home</a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#hero">Heroes</a></li>
          <li><a href="#team">Teams</a></li>
        </ul>
        <form class="navbar-form navbar-left" role="search">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
      </div>
    </div>
  </nav>
</div>

  <div ng-view >

  </div>

</body>
</html>