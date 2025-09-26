import type { Metadata } from "next";
import { Inter } from "next/font/google";
import Header from "./Componentes/Header";
import Footer from "./Componentes/Footer";
import "./globals.css";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pt-br">
      <body>
        <Header />
        {children}
        <Footer />
      </body>
    </html>
  );
}
