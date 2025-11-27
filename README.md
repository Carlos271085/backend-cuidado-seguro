🏥 Cuidado Seguro — Backend
API REST para la gestión de pacientes, tutores y profesionales

Tecnologías: Node.js · Express · MySQL/XAMPP · JWT · bcrypt · MVC

📌 Descripción del Proyecto

El backend de Cuidado Seguro provee una API REST que permite la comunicación entre el frontend (React) y la base de datos (MySQL).
Su objetivo es gestionar:

Pacientes

Tutores

Profesionales (Internos y Externos)

Mensajes

Controles médicos

Evoluciones clínicas

Autenticación y roles

El sistema sigue una arquitectura MVC + Services, aplicando buenas prácticas de seguridad, modularidad y escalabilidad.

🛠️ Tecnologías Utilizadas

Node.js (v18+ recomendado)

Express.js

MySQL (local con XAMPP)

Sequelize ORM o query manual (ajustable)

JWT (JSON Web Token) para autenticación

bcrypt para cifrado de contraseñas

dotenv para variables de entorno

CORS configurado para permitir comunicación con el frontend (React)

📂 Estructura del Proyecto
cuidado-seguro-backend/
│
├── src/
│   ├── config/
│   │   └── db.js               # Conexión MySQL
│   ├── controllers/            # Controladores (lógica de endpoints)
│   ├── routes/                 # Rutas de la API
│   ├── middleware/
│   │   ├── auth.js             # Validación JWT
│   │   └── errorHandler.js
│   ├── models/                 # Modelos de la BD
│   ├── services/               # Lógica de negocio
│   └── app.js                  # Configuración principal de Express
│
├── .env                        # Variables de entorno (no subir)
├── package.json
└── README.md

⚙️ Instalación y Configuración
1️⃣ Clonar el repositorio
git clone https://github.com/usuario/cuidado-seguro-backend.git
cd cuidado-seguro-backend

2️⃣ Instalar dependencias
npm install

3️⃣ Crear archivo .env
PORT=4000
DB_HOST=localhost
DB_USER=root
DB_PASSWORD=
DB_NAME=cuidado_seguro
JWT_SECRET=tu_clave_secreta_jwt

4️⃣ Iniciar el servidor
npm run dev


Servidor disponible en:
👉 http://localhost:4000

🧪 Endpoints Principales (versión inicial)
🔐 Autenticación
Método	Endpoint	Descripción
POST	/auth/register	Registro de usuarios
POST	/auth/login	Inicio de sesión y entrega de JWT
👤 Usuarios
Método	Endpoint	Descripción
GET	/usuarios/:id	Obtener perfil según tipo
PUT	/usuarios/:id	Actualizar datos
🧑‍⚕️ Profesionales
Método	Endpoint	Descripción
GET	/profesionales	Listar profesionales
POST	/profesionales	Crear profesional
🧒 Pacientes
Método	Endpoint	Descripción
GET	/pacientes	Listar pacientes
GET	/pacientes/:id	Obtener detalle
POST	/pacientes	Agregar paciente
💬 Mensajes
Método	Endpoint	Descripción
POST	/mensajes	Enviar mensaje
GET	/mensajes/:idPaciente	Obtener mensajes del paciente

(Mañana podemos agregar todos los endpoints finales y ejemplos de uso.)

🔒 Seguridad Implementada

Hash de contraseñas con bcrypt

Autenticación con JWT

Middleware de autorización por roles

Sanitización de entrada

Manejo centralizado de errores

🧱 Base de Datos (MySQL)

El proyecto se ejecuta con XAMPP.
Tablas recomendadas:

usuarios

tutores

profesionales

pacientes

mensajes

controles

evoluciones

instituciones

tipos_profesional

(Si quieres mañana te hago el modelo ER bonito en imagen + script SQL completo.)

🚀 Próximos Pasos

Implementar pruebas unitarias

Deploy en AWS EC2 con PM2

Conexión HTTPS y dominio

Documentación completa con Swagger

📄 Licencia

Este proyecto está bajo la licencia MIT.

🤝 Autor

Desarrollado por Carlos Bernal como parte del proyecto académico Cuidado Seguro.
