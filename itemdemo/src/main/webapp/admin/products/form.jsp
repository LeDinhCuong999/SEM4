<%@ page import="com.example.itemdemo.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        Product product = (Product) request.getAttribute("product");
        int action = (int) request.getAttribute("action");
        String url = "/admin/products/create";
        if(action == 2){
            url = "/admin/products/edit";
        }
    %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AdminLTE 3 | Form</title>

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
                        <h1>Form</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Form</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <!-- left column -->
                    <div class="col-md-12">
                        <!-- jquery validation -->
                        <div class="card card-primary">
                            <div class="card-header">
                                <h3 class="card-title">Create Product</h3>
                            </div>
                            <!-- /.card-header -->
                            <!-- form start -->
                            <a href="/admin/products/list">Back to list</a>
                            <form id="quickForm" action="<%=url%>" method="post">
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="Id">Id</label>
                                        <input type="tel" name="Id" class="form-control" id="Id" value="<%=product.getId()%>" <%=action == 2 ?"readonly":""%>>
                                    </div>
                                    <div class="form-group">
                                        <label for="Name">Name</label>
                                        <input type="text" name="Name" class="form-control" id="Name" value="<%=product.getName()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="Price">Price</label>
                                        <input type="text" name="Price" class="form-control" id="Price" value="<%=product.getPrice()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="Thumbnail">Thumbnail</label>
                                        <input type="text" name="Thumbnail" class="form-control" id="Thumbnail" value="<%=product.getThumbnail()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="Content">Content</label>
                                        <input type="text" name="Content" class="form-control" id="Content" value="<%=product.getContent()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="Qty">Qty</label>
                                        <input type="number" name="Qty" class="form-control" id="Qty" value="<%=product.getQty()%>">
                                    </div>
                                </div>
                                <!-- /.card-body -->
                                <div class="card-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>
                        <!-- /.card -->
                    </div>
                    <!--/.col (left) -->
                    <!-- right column -->
                    <div class="col-md-6">

                    </div>
                    <!--/.col (right) -->
                </div>
                <!-- /.row -->
            </div><!-- /.container-fluid -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/footer.jsp"></jsp:include>

</div>
<!-- ./wrapper -->

<!-- jQuery -->
<jsp:include page="../includes/script.jsp"></jsp:include>


</body>
</html>
