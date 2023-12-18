module.exports = {
  packagerConfig: {
    asar: true,
    extraResource: [
      '../ilkFlow.Backend/dist/manage/_internal',
      '../ilkFlow.Backend/dist/manage/manage.exe',
    ],
    icon: './src/img/logo_256x256',
  },
  rebuildConfig: {},
  makers: [
    {
      name: '@electron-forge/maker-squirrel',
      config: {
        // loadingGif:'./src/img/loading_0.gif'
        //iconUrl: './src/img/logo_256x256.ico',
        setupIcon: './src/img/logo_256x256.ico',
      },
    },
    {
      name: '@electron-forge/maker-zip',
    },
    {
      name: '@electron-forge/maker-deb',
      config: {},
    },
    {
      name: '@electron-forge/maker-rpm',
      config: {},
    },
  ],
  plugins: [
    {
      name: '@electron-forge/plugin-auto-unpack-natives',
      config: {},
    },
  ],
};
