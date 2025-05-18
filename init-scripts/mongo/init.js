// Switch to the ecommerce database
db = db.getSiblingDB('ecommerce');

// Create products collection and insert sample data
db.products.insertMany([
    {
        name: "Premium Coffee Maker",
        description: "Professional-grade coffee maker with temperature control",
        price: NumberDecimal("199.99"),
        stockQuantity: 50,
        categories: ["Appliances", "Kitchen"],
        images: [
            "coffee-maker-1.jpg",
            "coffee-maker-2.jpg"
        ],
        specifications: [
            { name: "Capacity", value: "12 cups" },
            { name: "Color", value: "Stainless Steel" }
        ],
        created_at: new Date(),
        updated_at: new Date()
    },
    {
        name: "Smart Watch Pro",
        description: "Advanced fitness tracking and notifications",
        price: NumberDecimal("299.99"),
        stockQuantity: 100,
        categories: ["Electronics", "Wearables"],
        images: [
            "smartwatch-1.jpg",
            "smartwatch-2.jpg"
        ],
        specifications: [
            { name: "Battery Life", value: "5 days" },
            { name: "Water Resistance", value: "50m" }
        ],
        created_at: new Date(),
        updated_at: new Date()
    },
    {
        name: "Ergonomic Office Chair",
        description: "Comfortable chair with lumbar support",
        price: NumberDecimal("249.99"),
        stockQuantity: 30,
        categories: ["Furniture", "Office"],
        images: [
            "chair-1.jpg",
            "chair-2.jpg"
        ],
        specifications: [
            { name: "Weight Capacity", value: "300 lbs" },
            { name: "Material", value: "Mesh" }
        ],
        created_at: new Date(),
        updated_at: new Date()
    }
]);

// Create reviews collection and insert sample data
db.reviews.insertMany([
    {
        product_id: db.products.findOne({name: "Premium Coffee Maker"})._id,
        user_id: 1,
        rating: 5,
        title: "Excellent Coffee Maker",
        comment: "Makes perfect coffee every time. Temperature control is amazing!",
        created_at: new Date(),
        updated_at: new Date()
    },
    {
        product_id: db.products.findOne({name: "Smart Watch Pro"})._id,
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