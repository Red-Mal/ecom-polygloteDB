"use client";

import Image from 'next/image';
import { Card, CardContent, CardFooter, CardHeader } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { useState } from 'react';

interface ProductCardProps {
  id: string;
  name: string;
  price: number;
  description: string;
  imageUrl: string | null;
}

export function ProductCard({ id, name, price, description, imageUrl }: ProductCardProps) {
  const [imgSrc, setImgSrc] = useState(imageUrl || 'https://via.placeholder.com/400');
  const [isLoading, setIsLoading] = useState(true);

  return (
    <Card className="flex flex-col h-full">
      <CardHeader className="p-0">
        <div className="aspect-square relative overflow-hidden rounded-t-lg bg-muted">
          <Image
            src={imgSrc}
            alt={name}
            fill
            className={`object-cover transition-transform hover:scale-105 ${
              isLoading ? 'opacity-0' : 'opacity-100'
            }`}
            sizes="(max-width: 768px) 100vw, (max-width: 1200px) 50vw, 33vw"
            onLoad={() => setIsLoading(false)}
            onError={() => {
              setImgSrc('https://via.placeholder.com/400');
              setIsLoading(false);
            }}
          />
        </div>
      </CardHeader>
      <CardContent className="flex-grow p-4">
        <div className="flex justify-between items-start mb-2">
          <h3 className="font-semibold text-lg line-clamp-1">{name}</h3>
          <p className="font-bold text-primary">${price.toFixed(2)}</p>
        </div>
        <p className="text-muted-foreground text-sm line-clamp-2">{description}</p>
      </CardContent>
      <CardFooter className="p-4 pt-0">
        <Button className="w-full" variant="default">Add to Cart</Button>
      </CardFooter>
    </Card>
  );
} 