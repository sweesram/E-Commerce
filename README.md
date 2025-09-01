# E-Commerce Website - Spring Boot + React.js

A full-stack e-commerce application built with Spring Boot (Backend) and React.js (Frontend) with Redux state management and user authentication.

## 🚀 Features

### Core Features
- ✅ **Product Listing**: View all available products with images and details
- ✅ **Product Detail View**: Detailed view of individual products
- ✅ **Shopping Cart**: Add, remove, and manage cart items
- ✅ **Search Functionality**: Search products by name or keyword
- ✅ **Category Filtering**: Filter products by categories
- ✅ **Responsive Design**: Mobile-friendly UI with Bootstrap

### Bonus Features (Assignment Requirements)
- ✅ **User Authentication**: Login and Registration system
- ✅ **Redux State Management**: 3rd-party state management using Redux Toolkit
- ✅ **RESTful API**: Complete backend API with proper HTTP methods
- ✅ **Database Integration**: PostgreSQL/H2 database with JPA
- ✅ **Image Upload**: Product image management
- ✅ **Stock Management**: Real-time stock quantity tracking

## 🏗️ Architecture

### High-Level Architecture Diagram

```
┌─────────────────┐    HTTP/REST    ┌─────────────────┐    Database    ┌─────────────────┐
│   React.js      │ ◄────────────► │   Spring Boot   │ ◄────────────► │   PostgreSQL    │
│   Frontend      │                 │   Backend       │                 │   Database      │
│                 │                 │                 │                 │                 │
│ ┌─────────────┐ │                 │ ┌─────────────┐ │                 │ ┌─────────────┐ │
│ │   Redux     │ │                 │ │ Controllers │ │                 │ │   Users     │ │
│ │   Store     │ │                 │ │             │ │                 │ │             │ │
│ └─────────────┘ │                 │ └─────────────┘ │                 │ │   Products  │ │
│ ┌─────────────┐ │                 │ ┌─────────────┐ │                 │ │             │ │
│ │ Components  │ │                 │ │  Services   │ │                 │ │   Cart      │ │
│ │             │ │                 │ │             │ │                 │ │             │ │
│ │ - Home      │ │                 │ │ - Auth      │ │                 │ └─────────────┘ │
│ │ - Product   │ │                 │ │ - Product   │ │                 │                 │
│ │ - Cart      │ │                 │ │ - Cart      │ │                 │                 │
│ │ - Login     │ │                 │ │ - User       │ │                 │                 │
│ │ - Register  │ │                 │ └─────────────┘ │                 │                 │
│ └─────────────┘ │                 │ ┌─────────────┐ │                 │                 │
│ ┌─────────────┐ │                 │ │ Repositories│ │                 │                 │
│ │   Axios     │ │                 │ │             │ │                 │                 │
│ │ HTTP Client │ │                 │ └─────────────┘ │                 │                 │
│ └─────────────┘ │                 │ ┌─────────────┐ │                 │                 │
└─────────────────┘                 │ │   Models    │ │                 │                 │
                                   │ │             │ │                 │                 │
                                   │ │ - User      │ │                 │                 │
                                   │ │ - Product   │ │                 │                 │
                                   │ │ - Cart      │ │                 │                 │
                                   │ └─────────────┘ │                 │                 │
                                   └─────────────────┘                 └─────────────────┘
```

### Technology Stack

**Frontend:**
- React.js 18
- Redux Toolkit (State Management)
- React Router DOM
- Axios (HTTP Client)
- Bootstrap 5 (UI Framework)

**Backend:**
- Spring Boot 3.3.3
- Spring Data JPA
- Spring Security
- PostgreSQL/H2 Database
- Maven (Build Tool)

## 📦 Installation & Setup

### Prerequisites
- Java 21 or higher
- Node.js 16 or higher
- npm or yarn
- PostgreSQL (optional, H2 is used by default)

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SpringBoot-Reactjs-Ecommerce
   ```

2. **Navigate to backend directory**
   ```bash
   cd Ecommerce-Backend
   ```

3. **Configure database** (Optional - H2 is used by default)
   Edit `src/main/resources/application.properties`:
   ```properties
   # For PostgreSQL
   spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Run the Spring Boot application**
   ```bash
   # Using Maven
   ./mvnw spring-boot:run
   
   # Or using IDE
   # Run EcomProjApplication.java
   ```

   The backend will start on `http://localhost:8080`

### Frontend Setup

1. **Navigate to frontend directory**
   ```bash
   cd Ecommerce-Frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm run dev
   ```

   The frontend will start on `http://localhost:5173`

## 🎯 API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login

### Products
- `GET /api/products` - Get all products
- `GET /api/product/{id}` - Get product by ID
- `POST /api/product` - Add new product
- `PUT /api/product/{id}` - Update product
- `DELETE /api/product/{id}` - Delete product
- `GET /api/products/search?keyword={keyword}` - Search products
- `GET /api/product/{id}/image` - Get product image

### Cart
- `GET /api/cart/{userId}` - Get user's cart
- `POST /api/cart/add` - Add item to cart
- `PUT /api/cart/{userId}/product/{productId}` - Update cart quantity
- `DELETE /api/cart/{userId}/product/{productId}` - Remove item from cart
- `DELETE /api/cart/{userId}` - Clear cart
- `GET /api/cart/{userId}/total` - Get cart total

## 🔐 Authentication Flow

1. **Registration**: Users can create new accounts with email, password, and personal details
2. **Login**: Users authenticate with email and password
3. **Session Management**: JWT tokens for secure authentication
4. **Protected Routes**: Cart and user-specific features require authentication

## 🛒 Shopping Cart Features

- Add products to cart with quantity selection
- Real-time stock validation
- Cart persistence across sessions
- Quantity management (increase/decrease)
- Remove items from cart
- Cart total calculation
- Checkout process with stock updates

## 🎨 UI/UX Features

- **Responsive Design**: Works on desktop, tablet, and mobile
- **Dark/Light Theme**: Toggle between themes
- **Search Functionality**: Real-time product search
- **Category Filtering**: Filter products by category
- **Product Images**: High-quality product images
- **Loading States**: Smooth loading animations
- **Error Handling**: User-friendly error messages

## 📁 Project Structure

```
SpringBoot-Reactjs-Ecommerce/
├── Ecommerce-Backend/
│   ├── src/main/java/com/cart/ecom_proj/
│   │   ├── controller/
│   │   │   ├── ProductController.java
│   │   │   ├── AuthController.java
│   │   │   └── CartController.java
│   │   ├── service/
│   │   │   ├── ProductService.java
│   │   │   ├── UserService.java
│   │   │   └── CartService.java
│   │   ├── model/
│   │   │   ├── Product.java
│   │   │   ├── User.java
│   │   │   └── Cart.java
│   │   ├── repo/
│   │   │   ├── ProductRepo.java
│   │   │   ├── UserRepo.java
│   │   │   └── CartRepo.java
│   │   └── config/
│   │       └── SecurityConfig.java
│   └── src/main/resources/
│       └── application.properties
├── Ecommerce-Frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── Home.jsx
│   │   │   ├── Product.jsx
│   │   │   ├── Cart.jsx
│   │   │   ├── Login.jsx
│   │   │   ├── Register.jsx
│   │   │   └── Navbar.jsx
│   │   ├── store/
│   │   │   ├── store.js
│   │   │   └── slices/
│   │   │       ├── authSlice.js
│   │   │       ├── cartSlice.js
│   │   │       └── productSlice.js
│   │   └── App.jsx
│   └── package.json
└── README.md
```

## 🚀 Deployment

### Backend Deployment
1. Build the JAR file:
   ```bash
   ./mvnw clean package
   ```

2. Run the JAR file:
   ```bash
   java -jar target/ecom-proj-0.0.1-SNAPSHOT.jar
   ```

### Frontend Deployment
1. Build for production:
   ```bash
   npm run build
   ```

2. Deploy the `dist` folder to your hosting service (Netlify, Vercel, etc.)

## 🧪 Testing

### Backend Testing
```bash
cd Ecommerce-Backend
./mvnw test
```

### Frontend Testing
```bash
cd Ecommerce-Frontend
npm test
```

## 📝 Assignment Requirements Checklist

- ✅ **Users can view all products** - Implemented in Home component
- ✅ **Users can add items to cart** - Implemented with Redux cart management
- ✅ **Users can view detailed product view** - Implemented in Product component
- ✅ **Authentication (Login/Sign-Up)** - Implemented with Spring Security
- ✅ **3rd-party state management** - Implemented with Redux Toolkit
- ✅ **REST API communication** - Implemented with Axios
- ✅ **Backend server** - Spring Boot with all required endpoints
- ✅ **High-Level Architecture Diagram** - Included in README
- ✅ **Codebase on GitHub** - Ready for repository hosting
- ✅ **Setup instructions** - Comprehensive README with instructions

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Harish Kumar Gatti**
- LinkedIn: [Harish Kumar Gatti](https://www.linkedin.com/in/harish-kumar-gatti-663066249/)
- GitHub: [Your GitHub Profile]

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- React.js team for the frontend library
- Redux Toolkit team for state management
- Bootstrap team for the UI framework

