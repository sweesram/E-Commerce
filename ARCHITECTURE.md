# E-Commerce Application Architecture

## System Overview

This e-commerce application follows a modern full-stack architecture with clear separation of concerns between frontend and backend components.

## Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                                    CLIENT LAYER                                 │
├─────────────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   React.js      │  │   Redux Store   │  │   React Router  │  │    Axios    │ │
│  │   Components    │  │   (State Mgmt)  │  │   (Routing)     │  │ (HTTP Client)│ │
│  │                 │  │                 │  │                 │  │             │ │
│  │ • Home          │  │ • Auth Slice    │  │ • Route Guards  │  │ • API Calls │ │
│  │ • Product       │  │ • Cart Slice    │  │ • Navigation    │  │ • Interceptors│ │
│  │ • Cart          │  │ • Product Slice  │  │ • History       │  │ • Error Handling│ │
│  │ • Login         │  │ • Async Thunks  │  │                 │  │             │ │
│  │ • Register      │  │ • Reducers      │  │                 │  │             │ │
│  │ • Navbar        │  │ • Actions       │  │                 │  │             │ │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────────────────────────┘
                                        │
                                        │ HTTP/REST API
                                        ▼
┌─────────────────────────────────────────────────────────────────────────────────┐
│                                   API GATEWAY                                   │
├─────────────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   CORS         │  │   Security      │  │   Validation    │  │   Logging   │ │
│  │   Configuration│  │   Configuration  │  │   Middleware    │  │   Middleware│ │
│  │                 │  │                 │  │                 │  │             │ │
│  │ • Cross-Origin │  │ • Authentication │  │ • Input Validation│ • Request Logs│ │
│  │ • Headers      │  │ • Authorization  │  │ • Data Sanitization│ • Error Logs │ │
│  │ • Methods      │  │ • JWT Tokens     │  │ • Schema Validation│ • Performance│ │
│  │ • Credentials  │  │ • Password Enc.  │  │ • Error Handling │   Monitoring │ │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────────────────────────┘
                                        │
                                        │ Business Logic
                                        ▼
┌─────────────────────────────────────────────────────────────────────────────────┐
│                                APPLICATION LAYER                                │
├─────────────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   Controllers   │  │    Services      │  │   Repositories  │  │   Models    │ │
│  │                 │  │                 │  │                 │  │             │ │
│  │ • ProductCtrl   │  │ • ProductService│  │ • ProductRepo   │  │ • Product   │ │
│  │ • AuthCtrl      │  │ • UserService    │  │ • UserRepo      │  │ • User      │ │
│  │ • CartCtrl      │  │ • CartService    │  │ • CartRepo      │  │ • Cart      │ │
│  │                 │  │                 │  │                 │  │             │ │
│  │ • REST Endpoints│  │ • Business Logic │  │ • Data Access    │  │ • JPA Entities│ │
│  │ • Request/Resp  │  │ • Validation    │  │ • CRUD Operations│  │ • Relationships│ │
│  │ • Error Handling│  │ • Transactions   │  │ • Queries       │  │ • Constraints │ │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────────────────────────┘
                                        │
                                        │ Data Access
                                        ▼
┌─────────────────────────────────────────────────────────────────────────────────┐
│                                  DATA LAYER                                     │
├─────────────────────────────────────────────────────────────────────────────────┤
│  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────────┐  ┌─────────────┐ │
│  │   JPA/Hibernate │  │   Connection    │  │   Database      │  │   File      │ │
│  │   ORM          │  │   Pool           │  │   Schema        │  │   Storage   │ │
│  │                 │  │                 │  │                 │  │             │ │
│  │ • Entity Mgmt   │  │ • Connection Mgmt│  │ • Tables       │  │ • Images    │ │
│  │ • Relationships │  │ • Pooling       │  │ • Indexes      │  │ • Static Files│ │
│  │ • Transactions  │  │ • Monitoring    │  │ • Constraints  │  │ • Uploads   │ │
│  │ • Caching       │  │ • Failover      │  │ • Triggers     │  │ • Downloads │ │
│  └─────────────────┘  └─────────────────┘  └─────────────────┘  └─────────────┘ │
└─────────────────────────────────────────────────────────────────────────────────┘
```

## Component Details

### Frontend Architecture

#### 1. React Components
- **Home**: Product listing with filtering and search
- **Product**: Detailed product view with add-to-cart functionality
- **Cart**: Shopping cart management with quantity controls
- **Login/Register**: Authentication forms with validation
- **Navbar**: Navigation with theme toggle and user status

#### 2. Redux Store Structure
```javascript
{
  auth: {
    user: null,
    isAuthenticated: false,
    loading: false,
    error: null
  },
  cart: {
    items: [],
    loading: false,
    error: null,
    total: 0
  },
  product: {
    products: [],
    selectedProduct: null,
    loading: false,
    error: null,
    searchResults: []
  }
}
```

#### 3. Redux Slices
- **authSlice**: User authentication state management
- **cartSlice**: Shopping cart state management
- **productSlice**: Product data state management

### Backend Architecture

#### 1. Controllers Layer
- **ProductController**: Product CRUD operations and image handling
- **AuthController**: User registration and authentication
- **CartController**: Cart management operations

#### 2. Services Layer
- **ProductService**: Product business logic and validation
- **UserService**: User management and authentication logic
- **CartService**: Cart operations and stock validation

#### 3. Repository Layer
- **ProductRepo**: Product data access operations
- **UserRepo**: User data access operations
- **CartRepo**: Cart data access operations

#### 4. Model Layer
- **Product**: Product entity with JPA annotations
- **User**: User entity with authentication fields
- **Cart**: Cart entity with relationships

## Data Flow

### 1. Product Listing Flow
```
User Request → React Component → Redux Action → Axios → Spring Controller → Service → Repository → Database
```

### 2. Authentication Flow
```
Login Form → Redux Auth Action → Spring Auth Controller → User Service → Password Validation → JWT Token → Redux Store
```

### 3. Cart Management Flow
```
Add to Cart → Redux Cart Action → Spring Cart Controller → Cart Service → Stock Validation → Database Update → Redux Store Update
```

## Security Architecture

### 1. Authentication
- JWT-based authentication
- Password encryption using BCrypt
- Session management with localStorage

### 2. Authorization
- Role-based access control (USER, ADMIN)
- Protected routes in frontend
- API endpoint protection in backend

### 3. Data Validation
- Frontend form validation
- Backend input sanitization
- SQL injection prevention through JPA

## Performance Considerations

### 1. Frontend Optimization
- React component memoization
- Redux state normalization
- Lazy loading for routes
- Image optimization

### 2. Backend Optimization
- Database connection pooling
- JPA query optimization
- Caching strategies
- Async operations where appropriate

## Scalability Features

### 1. Horizontal Scaling
- Stateless backend design
- Database connection pooling
- Load balancer ready

### 2. Vertical Scaling
- Modular component architecture
- Service layer abstraction
- Repository pattern for data access

## Error Handling

### 1. Frontend Error Handling
- Redux error states
- Try-catch blocks in async operations
- User-friendly error messages
- Network error handling

### 2. Backend Error Handling
- Global exception handlers
- Custom exception classes
- Proper HTTP status codes
- Detailed error logging

## Testing Strategy

### 1. Frontend Testing
- Unit tests for Redux slices
- Component testing with React Testing Library
- Integration tests for API calls
- E2E testing with Cypress

### 2. Backend Testing
- Unit tests for services
- Integration tests for controllers
- Repository layer testing
- API endpoint testing

## Deployment Architecture

### 1. Development Environment
- Local development servers
- Hot reloading for frontend
- Spring Boot dev tools
- H2 in-memory database

### 2. Production Environment
- Frontend: Static file hosting (Netlify/Vercel)
- Backend: Cloud deployment (AWS/Google Cloud)
- Database: Managed PostgreSQL service
- CDN for static assets

## Monitoring and Logging

### 1. Application Monitoring
- Performance metrics
- Error tracking
- User analytics
- API usage statistics

### 2. Logging Strategy
- Structured logging
- Error logging with stack traces
- Request/response logging
- Security event logging
