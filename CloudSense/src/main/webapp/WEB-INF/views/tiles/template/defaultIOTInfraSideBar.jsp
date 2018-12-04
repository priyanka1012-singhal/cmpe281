	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src='<c:url value="/dist/img/avatar.png"/>' class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p>XYZ</p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active treeview">
              <a href="${pageContext.request.contextPath}/iotdashboard">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
              </a>
            </li>
             <li class="treeview">
              <a href="#">
                <i class="fa fa-lightbulb-o"></i> <span>Manage Sensor</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
               	<li class="active"><a href="${pageContext.request.contextPath}/viewsensor"><i class="fa fa-circle-o"></i>View Sensors</a></li>
                <li><a href="${pageContext.request.contextPath}/addsensor"><i class="fa fa-circle-o"></i>Add Sensor</a></li>
             
              </ul>
            </li>
              <li class="treeview">
              <a href="#">
                <i class="fa fa-gears"></i> <span>Manage Smart Node</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              	<li class="active"><a href="${pageContext.request.contextPath}/viewsmartnode"><i class="fa fa-circle-o"></i>View Smart Nodes</a></li>
                <li><a href="${pageContext.request.contextPath}/addsmartnode"><i class="fa fa-circle-o"></i>Add Smart Node</a></li>
               
              </ul>
            </li>
             <li class="treeview">
              <a href="#">
                <i class="fa fa-gears"></i> <span>Manage Cluster</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              	<li class="active"><a href="${pageContext.request.contextPath}/viewcluster"><i class="fa fa-circle-o"></i>View Clusters</a></li>
                <li><a href="${pageContext.request.contextPath}/addcluster"><i class="fa fa-circle-o"></i>Add Cluster</a></li>
              
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-tachometer"></i> <span>Monitor</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
               <ul class="treeview-menu">
                <li class="active"><a href="${pageContext.request.contextPath}/viewenergyusage"><i class="fa fa-circle-o"></i>Energy Usage</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>Alarms & Operations</a></li>
                <li><a href="#"><i class="fa fa-circle-o"></i>Generate Bill & Statements</a></li>
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-bar-chart-o"></i> <span>Generate Reports</span>
              </a>
               <ul class="treeview-menu">
              	<li><a href="${pageContext.request.contextPath}/sensordata/view"><i class="fa fa-circle-o"></i>View Sensor Data</a></li>
              </ul>
           </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>

     