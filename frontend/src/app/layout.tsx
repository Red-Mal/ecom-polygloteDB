import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import Link from "next/link";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "E-commerce Store",
  description: "Modern e-commerce store with polyglot persistence",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <header className="border-b">
          <nav className="container mx-auto px-4 py-4">
            <div className="flex justify-between items-center">
              <Link href="/" className="text-xl font-bold">
                EcomStore
              </Link>
              <div className="space-x-6">
                <Link href="/products" className="hover:text-primary">
                  Products
                </Link>
                <Link href="/cart" className="hover:text-primary">
                  Cart
                </Link>
              </div>
            </div>
          </nav>
        </header>
        <main>{children}</main>
      </body>
    </html>
  );
}
