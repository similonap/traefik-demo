FROM node:lts-slim as build
WORKDIR /src
RUN npm install -g @angular/cli
COPY . ./
RUN npm ci
RUN ng build --configuration=production

FROM nginx:stable AS final
COPY --from=build src/dist/*/browser  /usr/share/nginx/html
EXPOSE 80