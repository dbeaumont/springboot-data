# Étape de build
FROM node:18-alpine AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build -- --configuration=production

# Étape finale avec Nginx
FROM nginx:1.25-alpine
COPY --from=builder /app/dist/message-frontend /usr/share/nginx/html
COPY docker/nginx/localhost.conf /etc/nginx/conf.d/localhost.conf


# Sécurité renforcée
RUN rm -rf /etc/nginx/conf.d/default.conf && \
    chown -R nginx:nginx /usr/share/nginx/html && \
    chmod -R 755 /usr/share/nginx/html

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
