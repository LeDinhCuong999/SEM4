<%@ page import="java.util.List" %>
<%@ page import="com.example.itemdemo.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        List<Product> listProduct = (List<Product>)request.getAttribute("listProduct");
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | List</title>

    <jsp:include page="../includes/head.jsp"></jsp:include>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Navbar -->
    <jsp:include page="../includes/navbar.jsp"></jsp:include>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <jsp:include page="../includes/sidebar.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>DataTables</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">DataTables</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <!-- /.card -->
                        <a href="/admin/products/create">Create new product</a>
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">List Product</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <table id="example1" class="table table-bordered table-striped">

                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Thumbnail</th>
                                        <th>Content</th>
                                        <th>Qty</th>
                                        <th>Create At</th>
                                        <th>Update At</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>

                                    <%for (Product pr : listProduct) {
                                    %>
                                    <tbody>
                                    <th><%=pr.getId()%></th>
                                    <th><%=pr.getName()%></th>
                                    <th><%=pr.getPrice()%></th>
                                    <th><%=pr.getThumbnail()%></th>
                                    <th><%=pr.getContent()%></th>
                                    <th><%=pr.getQty()%></th>
                                    <th><%=pr.getCreatedAt()%></th>
                                    <th><%=pr.getStatus()%></th>
                                    <th><%=pr.getQty()%></th>
                                    <th><a href="/admin/products/detail?id=<%=pr.getId()%>">Detail</a>&nbsp;&nbsp;
                                        <a href="/admin/products/edit?id=<%=pr.getId()%>">Edit</a>&nbsp;&nbsp;
                                        <a href="/admin/products/delete?id=<%=pr.getId()%>" onclick="confirm('Are you sure?')">Delete</a></th>
                                    </tbody>
                                    <%}%>

                                    <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Name</th>
                                        <th>Price</th>
                                        <th>Thumbnail</th>
                                        <th>Content</th>
                                        <th>Qty</th>
                                        <th>Create At</th>
                                        <th>Update At</th>
                                        <th>Status</th>
                                        <th>Action</th>
                                    </tr>
                                    </tfoot>

                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div>
<!-- ./wrapper -->

<jsp:include page="../includes/script.jsp"></jsp:include>

</body>
</html>
