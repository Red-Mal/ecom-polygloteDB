// Switch to admin database
db = db.getSiblingDB('admin');

// Try to authenticate first, if it fails, create the user
try {
    db.auth('mongodb', 'mongodb');
} catch (err) {
    db.createUser({
        user: 'mongodb',
        pwd: 'mongodb',
        roles: [
            { role: 'readWrite', db: 'ecommerce' },
            { role: 'dbAdmin', db: 'ecommerce' },
            { role: 'userAdmin', db: 'ecommerce' }
        ]
    });
}

// Switch to ecommerce database
db = db.getSiblingDB('ecommerce');

// Drop existing collections if they exist
try {
    db.products.drop();
} catch (err) {
    // Collection might not exist, ignore
}

try {
    db.reviews.drop();
} catch (err) {
    // Collection might not exist, ignore
}

// Insert products
db.products.insertMany([
    {
        name: "Modern Minimalist Desk Lamp",
        description: "LED desk lamp with adjustable brightness and color temperature. Perfect for home office or study.",
        price: 49.99,
        stockQuantity: 100,
        categories: ["Lighting", "Home Office"],
        images: ["https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Wireless Noise-Cancelling Headphones",
        description: "Premium over-ear headphones with active noise cancellation and 30-hour battery life.",
        price: 199.99,
        stockQuantity: 50,
        categories: ["Electronics", "Audio"],
        images: ["https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Artisan Coffee Maker",
        description: "Pour-over coffee maker with precision temperature control and timer.",
        price: 159.99,
        stockQuantity: 75,
        categories: ["Kitchen", "Appliances"],
        images: ["https://images.unsplash.com/photo-1495474472287-4d71bcdd2085?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Smart Fitness Watch",
        description: "Advanced fitness tracker with heart rate monitoring, GPS, and sleep tracking.",
        price: 129.99,
        stockQuantity: 200,
        categories: ["Electronics", "Fitness"],
        images: ["https://images.unsplash.com/photo-1579586337278-3befd40fd17a?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Ergonomic Office Chair",
        description: "High-back mesh office chair with lumbar support and adjustable armrests.",
        price: 249.99,
        stockQuantity: 30,
        categories: ["Furniture", "Home Office"],
        images: ["https://images.unsplash.com/photo-1580480055273-228ff5388ef8?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Premium Yoga Mat",
        description: "Non-slip, eco-friendly yoga mat with alignment lines and carrying strap.",
        price: 79.99,
        stockQuantity: 150,
        categories: ["Fitness", "Wellness"],
        images: ["https://images.unsplash.com/photo-1601925260368-ae2f83cf8b7f?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Mechanical Keyboard",
        description: "RGB mechanical gaming keyboard with customizable switches and macro keys.",
        price: 149.99,
        stockQuantity: 80,
        categories: ["Electronics", "Gaming"],
        images: ["https://images.unsplash.com/photo-1511467687858-23d96c32e4ae?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Smart Plant Pot",
        description: "Self-watering plant pot with soil moisture monitoring and mobile app connectivity.",
        price: 39.99,
        stockQuantity: 100,
        categories: ["Home & Garden", "Smart Home"],
        images: ["https://images.unsplash.com/photo-1485955900006-10f4d324d411?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Portable Power Bank",
        description: "20000mAh power bank with fast charging and multiple device support.",
        price: 49.99,
        stockQuantity: 200,
        categories: ["Electronics", "Accessories"],
        images: ["https://images.unsplash.com/photo-1609091839311-d5365f9ff1c5?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    },
    {
        name: "Minimalist Wall Clock",
        description: "Modern wall clock with silent movement and scandinavian design.",
        price: 34.99,
        stockQuantity: 120,
        categories: ["Home Decor", "Accessories"],
        images: ["https://images.unsplash.com/photo-1563861826100-9cb868fdbe1c?w=800&auto=format&fit=crop&q=80"],
        createdAt: new Date(),
        updatedAt: new Date()
    }
]);

// Create reviews collection and insert sample data
db.reviews.insertMany([
    {
        product_id: db.products.findOne({name: "Artisan Coffee Maker"})._id,
        user_id: 1,
        rating: 5,
        title: "Excellent Coffee Maker",
        comment: "Makes perfect coffee every time. Temperature control is amazing!",
        created_at: new Date(),
        updated_at: new Date()
    },
    {
        product_id: db.products.findOne({name: "Smart Fitness Watch"})._id,
        user_id: 2,
        rating: 4,
        title: "Great Features",
        comment: "Love the fitness tracking, battery life could be better",
        created_at: new Date(),
        updated_at: new Date()
    },
    {
        product_id: db.products.findOne({name: "Ergonomic Office Chair"})._id,
        user_id: 1,
        rating: 5,
        title: "Very Comfortable",
        comment: "Best office chair I've ever used. Great lumbar support!",
        created_at: new Date(),
        updated_at: new Date()
    }
]); 