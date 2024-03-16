# Demo #2
Anwendung zum Durchsuchen eines Datensatzes.

Backend: JavaScript / Next.js

Frontend: JavaScript / Next.js

Datenbank: redis / redisJSON / redisSearch

## Usage

```
git clone <this-repo>
npm install
```

This demo requires that you have a Redis database running in the cloud or locally. Create a file named `.env.local` and export `REDIS_URL` with your connection details. Example: 

```
REDIS_URL=redis://default:PASSWORD@HOST:PORT
```