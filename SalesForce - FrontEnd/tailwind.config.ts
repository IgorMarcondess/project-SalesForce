import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    screens: {
      'mini': '450px',
      'sm': '640px',
      'md': '768px',
      'lg': '1024px',
      'xl': '1280px',
      '2xl': '1536px',
    },
    extend: {
      backgroundColor: {
        azulEscuro:{
          100: "#1D3557",
        }
      },
      textColor:{
        azulEscuro:{
          100: "#1D3557",
        },
      },
      width:{
        'vw50' : '50vw',
        'vw40' : '40vw',
      },
      fontFamily: {
        'titulo' : ["Righteous", "Sans-serif"],
        'comum' : ["Alata", "Sans-serif"]
      }
    },
  },
  plugins: [],
};
export default config;
