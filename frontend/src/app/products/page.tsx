import { ProductCard } from "@/components/product/ProductCard";
import { productApi } from "@/services";

async function getProducts() {
  try {
    return await productApi.getProducts();
  } catch (error) {
    console.error('Error fetching products:', error);
    return [];
  }
}

export default async function ProductsPage() {
  const products = await getProducts();

  return (
    <div className="container mx-auto py-8">
      <h1 className="text-3xl font-bold mb-8">Our Products</h1>
      {products.length === 0 ? (
        <div className="text-center text-muted-foreground">
          No products available at the moment.
        </div>
      ) : (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {products.map((product) => (
            <ProductCard key={product.id} {...product} />
          ))}
        </div>
      )}
    </div>
  );
} 