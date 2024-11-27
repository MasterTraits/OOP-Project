cd frontend || { echo "Failed to change directory to 'frontend'"; exit 1; }
# Open the default web browser to http://localhost:5173
if command -v xdg-open > /dev/null; then
  xdg-open http://localhost:5173
elif command -v open > /dev/null; then
  open http://localhost:5173
elif command -v start > /dev/null; then
  start http://localhost:5173
else
  echo "Could not detect the web browser to open http://localhost:5173"
fi
npm run dev