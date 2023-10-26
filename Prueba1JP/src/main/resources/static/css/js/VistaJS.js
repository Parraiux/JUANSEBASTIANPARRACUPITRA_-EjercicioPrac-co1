<!DOCTYPE html>
<html>
<head>
    <title>Estudiantes</title>
</head>
<body>
    <h1>Listado de Estudiantes</h1>

    <div id="estudiantes-list">

    </div>

    <button id="nuevo-estudiante">Nuevo Estudiante</button>

    <script>

        document.getElementById("nuevo-estudiante").addEventListener("click", function () {
            window.location.href = "/estudiantes/nuevo";
        });


        fetch("/estudiantes/listado")
            .then(response => response.text())
            .then(data => {
                document.getElementById("estudiantes-list").innerHTML = data;
            });
            

        function cargarEstudiantes() {
        fetch("/estudiantes/listado")
        .then(response => response.text())
        .then(data => {
        document.getElementById("estudiantes-list").innerHTML = data;
        });
        }


        cargarEstudiantes();
        
         const botonesEliminar = document.querySelectorAll(".eliminar-estudiante");

    botonesEliminar.forEach(boton => {
        boton.addEventListener("click", function () {
            const idEstudiante = boton.getAttribute("data-id"); 
            eliminarEstudiante(idEstudiante);
        });
    });

    function eliminarEstudiante(id) {
        fetch(`/estudiantes/eliminar/${id}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
        })
        .then(response => response.text())
        .then(() => {
            cargarEstudiantes();
        });
    }
    </script>
</body>
</html>
