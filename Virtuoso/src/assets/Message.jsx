export default function Message({output}) {
  return (
    <div className={`${output}`}>
      <svg width="34" height="33" viewBox="0 0 34 33" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path d="M0 0.5H34V25.5L13.5 26L6.5 32.5V25.5H0V0.5Z" fill="url(#paint0_linear_58_424)"/>
      <line x1="6" y1="8" x2="28" y2="8" stroke="#D9D9D9" stroke-width="2"/>
      <line x1="6" y1="13" x2="28" y2="13" stroke="#D9D9D9" stroke-width="2"/>
      <line x1="6" y1="18" x2="28" y2="18" stroke="#D9D9D9" stroke-width="2"/>
      <defs>
      <linearGradient id="paint0_linear_58_424" x1="17" y1="0.5" x2="17" y2="32.5" gradientUnits="userSpaceOnUse">
      <stop stop-color="#FFC067"/>
      <stop offset="1" stop-color="#99733E"/>
      </linearGradient>
      </defs>
      </svg>
    </div>
  )
}


