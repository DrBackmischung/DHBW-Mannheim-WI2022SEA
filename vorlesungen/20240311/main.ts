// Main
import { CatFactory, PorscheCayeneFactory } from "./factory";

const catFactory1 = CatFactory.getInstance();
const catFactory2 = CatFactory.getInstance();
const catFactory3 = CatFactory.getInstance();
const catFactory4 = CatFactory.getInstance();
const carFactory = new PorscheCayeneFactory();
const kitty = catFactory1.create();
const mauzi = catFactory4.create();
const hugo = carFactory.create();

console.log(kitty.eat());
console.log(mauzi.eat());