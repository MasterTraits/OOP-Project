import { useState } from 'react';
import { Document, Page } from 'react-pdf';
import { Button } from './ui/button';
import { ChevronLeftCircle, ChevronRightCircle, ZoomInIcon, ZoomOutIcon } from 'lucide-react';

export default function PDFReader() {
  const [numPages, setNumPages] = useState();
  const [pageNumber, setPageNumber] = useState(1);
  const [scale, setScale] = useState(1);
  const [position, setPosition] = useState(0);

  function onDocumentLoadSuccess({ numPages }) {
    setNumPages(numPages);
  }

  function zoomIn() {
    setScale(scale + 0.1);
  }

  function zoomOut() {
    setScale(scale > 0.1 ? scale - 0.1 : 0.1);
  }

  return (
    <div>
      <div className='flex justify-between items-center mb-4'>
        <div className='pr-10 flex gap-3'>
          <ChevronLeftCircle 
            onClick={() => setPageNumber(pageNumber > 1 ? pageNumber - 1 : 1)} 
            className='h-6 w-6 text-black rounded hover:bg-white'
          />
          <ChevronRightCircle 
            onClick={() => setPageNumber(pageNumber < numPages ? pageNumber + 1 : numPages)} 
            className='h-6 w-6 text-black rounded hover:bg-white'
          />
        </div>
        <p>
          Page {pageNumber} of {numPages}
        </p>
        <div className='pl-10 flex gap-3'>
          <ZoomOutIcon 
            onClick={zoomOut} 
            className='bg-blue-500 h-6 w-6 text-black rounded hover:bg-white'
          />
          <ZoomInIcon
            onClick={zoomIn} 
            className='bg-blue-500 h-6 w-6 text-black rounded hover:bg-white'
          />
        </div>
      </div>
      <div className='flex justify-center'>
        <Document file="/PE-COMMON-125A.pdf" onLoadSuccess={onDocumentLoadSuccess}>
          <Page 
            pageNumber={pageNumber} 
            renderTextLayer={false} 
            renderAnnotationLayer={false}
            scale={scale}
            width={window.innerWidth * 0.8}
          />
        </Document>
      </div>
    </div>
  );
}